package com.ljm.server.impl;

import com.ljm.server.Server;
import com.ljm.server.ServerStatus;
import com.ljm.server.config.ServerConfig;
import com.ljm.server.io.IoUtils;
import com.ljm.server.io.impl.SocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class SimpleServer implements Server {
    private static Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private volatile ServerStatus serverStatus = ServerStatus.STOPED;
    private final int port;
    private SocketConnector socketConnector;

    public SimpleServer(ServerConfig serverConfig) {
        this.port = serverConfig.getPort();
        socketConnector = new SocketConnector(this.port);
    }

    @Override
    public void start() throws IOException {
        socketConnector.start();
        this.serverStatus = ServerStatus.STARTED;
    }

    @Override
    public void stop() {
        socketConnector.stop();
        this.serverStatus = ServerStatus.STOPED;
        logger.info("Server stop");
    }

    @Override
    public ServerStatus getStatus() {
        return serverStatus;
    }

    @Override
    public int getPort() {
        return port;
    }
}
