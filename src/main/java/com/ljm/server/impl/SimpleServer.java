package com.ljm.server.impl;

import com.ljm.server.Server;
import com.ljm.server.ServerStatus;
import com.ljm.server.config.ServerConfig;
import com.ljm.server.io.IoUtils;
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
    private ServerSocket serverSocket;

    public SimpleServer(ServerConfig serverConfig) {
        this.port = serverConfig.getPort();
    }

    @Override
    public void start() throws IOException {
        //监听本地端口，如果监听不成功，抛出异常
        this.serverSocket = new ServerSocket(this.port);
        this.serverStatus = ServerStatus.STARTED;
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                logger.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            } finally {
                IoUtils.closeQuietly(socket);
            }
        }

    }

    @Override
    public void stop() {
        IoUtils.closeQuietly(this.serverSocket);
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
