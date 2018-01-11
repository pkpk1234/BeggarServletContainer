package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.demo.EchoEventHandler;
import com.ljm.server.demo.FileEventHandler;
import com.ljm.server.demo.NIOEchoEventHandler;
import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connector.ConnectorFactory;
import com.ljm.server.io.connector.impl.nio.SocketChannelConnector;
import com.ljm.server.io.connector.impl.socket.SocketConnector;
import com.ljm.server.io.connector.impl.socket.SocketConnectorConfig;
import com.ljm.server.io.connector.impl.socket.SocketConnectorFactory;
import com.ljm.server.io.event.listener.impl.ConnectionEventListener;
import com.ljm.server.io.event.listener.impl.SelectableChannleEventListener;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class BootStrap {
    public static void main(String[] args) throws IOException {
        EventListener<Connection> socketEventListener =
                new ConnectionEventListener(new EchoEventHandler());

        SocketConnector connector = SocketConnectorFactory.build(18080, socketEventListener);

        EventListener<Connection> socketEventListener2 =
                new ConnectionEventListener(new FileEventHandler(System.getProperty("user.dir")));

        SocketConnector connector2 =
                SocketConnectorFactory.build(18081, socketEventListener2);

        EventListener<SelectionKey> nioEventListener = new SelectableChannleEventListener(new NIOEchoEventHandler());
        SocketChannelConnector socketChannelConnector = new SocketChannelConnector(18082, nioEventListener);


        ServerConfig serverConfig = ServerConfig.builder()
                .addConnector(connector)
                .addConnector(connector2)
                .addConnector(socketChannelConnector).build();
        Server server = ServerFactory.getServer(serverConfig);
        server.start();
    }
}
