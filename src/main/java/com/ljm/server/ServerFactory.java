package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.event.impl.NIOEventListener;
import com.ljm.server.handler.impl.FileEventHandler;
import com.ljm.server.handler.impl.NIOEchoEventHandler;
import com.ljm.server.impl.SimpleServer;
import com.ljm.server.io.AbstractConnector;
import com.ljm.server.io.Connector;
import com.ljm.server.io.ConnectorFactory;
import com.ljm.server.io.impl.nio.SocketChannelConnector;
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
        SocketEventListener socketEventListener =
                new SocketEventListener(new FileEventHandler(System.getProperty("user.dir")));
        ConnectorFactory connectorFactory =
                new SocketConnectorFactory(new SocketConnectorConfig(serverConfig.getPort()), socketEventListener);

        NIOEventListener nioEventListener = new NIOEventListener(new NIOEchoEventHandler());
        SocketChannelConnector socketChannelConnector = new SocketChannelConnector(18081,nioEventListener);

        connectorList.add(connectorFactory.getConnector());
        connectorList.add(socketChannelConnector);
        return new SimpleServer(connectorList);
    }
}
