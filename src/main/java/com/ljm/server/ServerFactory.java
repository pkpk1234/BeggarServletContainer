package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.impl.SimpleServer;
import com.ljm.server.io.Connector;
import com.ljm.server.io.ConnectorFactory;
import com.ljm.server.io.impl.socket.SocketConnectorConfig;
import com.ljm.server.io.impl.socket.SocketConnectorFactory;
import com.ljm.server.event.impl.SocketEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class ServerFactory {
    /**
     * 返回Server实例
     *
     * @return
     */
    public static Server getServer(ServerConfig serverConfig) {
        List<Connector> connectorList = new ArrayList<>();
        SocketEventListener socketEventListener = new SocketEventListener();
        ConnectorFactory connectorFactory =
                new SocketConnectorFactory(new SocketConnectorConfig(serverConfig.getPort()), socketEventListener);
        connectorList.add(connectorFactory.getConnector());
        return new SimpleServer(serverConfig, connectorList);
    }
}
