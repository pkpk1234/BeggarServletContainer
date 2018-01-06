package com.ljm.server.io.impl;

import com.ljm.server.io.Connector;
import com.ljm.server.io.ConnectorException;
import com.ljm.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public class SocketConnector extends Connector {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketConnector.class);
    private final int port;
    private ServerSocket serverSocket;
    private volatile boolean started = false;

    public SocketConnector(int port) {
        this.port = port;
    }


    @Override
    protected void init() throws ConnectorException {
        //监听本地端口，如果监听不成功，抛出异常
        try {
            this.serverSocket = new ServerSocket(this.port);
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
                    LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
                } catch (IOException e) {
                    //单个Socket异常，不要影响整个Connector
                    LOGGER.error(e.getMessage(), e);
                } finally {
                    IoUtils.closeQuietly(socket);
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        this.started = false;
        IoUtils.closeQuietly(this.serverSocket);
    }
}
