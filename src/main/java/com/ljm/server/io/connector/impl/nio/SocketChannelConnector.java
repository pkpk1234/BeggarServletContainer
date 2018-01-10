package com.ljm.server.io.connector.impl.nio;

import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connector.AbstractConnector;
import com.ljm.server.io.connector.ConnectorException;
import com.ljm.server.io.utils.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/9
 */
public class SocketChannelConnector extends AbstractConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketChannelConnector.class);
    private static final String LOCALHOST = "localhost";
    private static final int DEFAULT_BACKLOG = 50;
    private final int port;
    private final String host;
    private final int backLog;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started = false;
    private final EventListener<SelectionKey> eventListener;

    public SocketChannelConnector(int port, String host, int backLog, EventListener<SelectionKey> eventListener) {
        this.port = port;
        this.host = host;
        this.backLog = backLog;
        this.eventListener = eventListener;
    }

    public SocketChannelConnector(int port, EventListener<SelectionKey> eventHandler) {
        this(port, LOCALHOST, DEFAULT_BACKLOG, eventHandler);
    }

    @Override
    protected void init() throws ConnectorException {
        try {
            InetAddress inetAddress = InetAddress.getByName(this.host);
            SocketAddress socketAddress = new InetSocketAddress(inetAddress, this.port);
            this.serverSocketChannel =
                    ServerSocketChannel.open();
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.bind(socketAddress, backLog);
            this.started = true;
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
    }

    @Override
    protected void acceptConnect() throws ConnectorException {

        new Thread(() -> {
            try {
                Selector selector = Selector.open();
                SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while (true) {
                    selector.select();
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator iterator = selectedKeys.iterator();
                    while (iterator.hasNext()) {
                        key = (SelectionKey) iterator.next();
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = ssc.accept();
                            socketChannel.configureBlocking(false);
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, buffer);
                            iterator.remove();
                            LOGGER.info("NIO Connector accept Connect from {}",
                                    socketChannel.getRemoteAddress());
                        } else if (key.isReadable()) {
                            read(key);
                            iterator.remove();
                        } else if (key.isWritable()) {
                            write(key);
                            iterator.remove();
                        }
                    }
                }
            } catch (ClosedChannelException e) {
                throw new ConnectorException(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    @Override
    protected void communicate(Connection connection) throws ConnectorException {

    }

    private void write(SelectionKey key) {
        callBack(key);
    }

    private void read(SelectionKey key) {
        callBack(key);
    }

    //@Override
    protected void callBack(SelectionKey key) throws ConnectorException {
        eventListener.onEvent(key);
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public void stop() {
        this.started = false;
        IoUtils.closeQuietly(this.serverSocketChannel);
    }
}
