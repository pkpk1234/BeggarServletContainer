package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.demo.EchoEventHandler;
import com.ljm.server.demo.FileEventHandler;
import com.ljm.server.demo.NIOEchoEventHandler;
import com.ljm.server.event.listener.EventListener;
import com.ljm.server.impl.SimpleServer;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connector.Connector;
import com.ljm.server.io.connector.ConnectorFactory;
import com.ljm.server.io.connector.impl.nio.SocketChannelConnector;
import com.ljm.server.io.connector.impl.socket.SocketConnectorConfig;
import com.ljm.server.io.connector.impl.socket.SocketConnectorFactory;
import com.ljm.server.io.event.listener.impl.ConnectionEventListener;
import com.ljm.server.io.event.listener.impl.SelectableChannleEventListener;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Arrays;
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
        return new SimpleServer(serverConfig.getConnectors());
    }
}
