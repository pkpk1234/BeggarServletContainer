package com.ljm.server.io.impl.socket;

import com.ljm.server.io.AbstractConnector;
import com.ljm.server.io.ConnectorException;
import com.ljm.server.event.EventListener;
import com.ljm.server.io.IoUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public class SocketConnector extends AbstractConnector<Socket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketConnector.class);
    private static final String LOCALHOST = "localhost";
    private static final int DEFAULT_BACKLOG = 50;
    private final int port;
    private final String host;
    private final int backLog;
    private ServerSocket serverSocket;
    private volatile boolean started = false;
    private final EventListener<Socket> eventListener;

    public SocketConnector(int port, EventListener<Socket> eventListener) {
        this(port, LOCALHOST, DEFAULT_BACKLOG, eventListener);
    }

    public SocketConnector(int port, String host, int backLog, EventListener<Socket> eventListener) {
        this.port = port;
        this.host = StringUtils.isBlank(host) ? LOCALHOST : host;
        this.backLog = backLog;
        this.eventListener = eventListener;
    }


    @Override
    protected void init() throws ConnectorException {

        //监听本地端口，如果监听不成功，抛出异常
        try {
            InetAddress inetAddress = InetAddress.getByName(this.host);
            this.serverSocket = new ServerSocket(this.port, backLog, inetAddress);
            this.started = true;
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
    }

    @Override
    protected void acceptConnect() throws ConnectorException {
        new Thread(() -> {
            while (true && started) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                    whenAccept(socket);
                } catch (Exception e) {
                    //单个Socket异常，不要影响整个Connector
                    LOGGER.error(e.getMessage(), e);
                } finally {
                    IoUtils.closeQuietly(socket);
                }
            }
        }).start();
    }

    @Override
    protected void whenAccept(Socket socketConnect) throws ConnectorException {
        eventListener.onEvent(socketConnect);
    }

    @Override
    public void stop() {
        this.started = false;
        IoUtils.closeQuietly(this.serverSocket);
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public String getHost() {
        return null;
    }
}
