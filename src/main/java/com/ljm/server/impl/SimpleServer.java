package com.ljm.server.impl;

import com.ljm.server.Server;
import com.ljm.server.ServerStatus;
import com.ljm.server.config.ServerConfig;
import com.ljm.server.io.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class SimpleServer implements Server {
    private static Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private volatile ServerStatus serverStatus = ServerStatus.STOPED;
    private final int port;
    private final List<Connector> connectorList;

    public SimpleServer(ServerConfig serverConfig, List<Connector> connectorList) {
        this.port = serverConfig.getPort();
        this.connectorList = connectorList;
    }

    @Override
    public void start() {
        connectorList.stream().forEach(connector -> connector.start());
        this.serverStatus = ServerStatus.STARTED;
    }

    @Override
    public void stop() {
        connectorList.stream().forEach(connector -> connector.stop());
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
