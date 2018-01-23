package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.demo.EchoEventHandler;
import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connector.impl.socket.SocketConnector;
import com.ljm.server.io.connector.impl.socket.SocketConnectorFactory;
import com.ljm.server.io.event.listener.impl.ConnectionEventListener;
import com.ljm.server.protocol.http.handler.HttpStaticResourceEventHandler;
import com.ljm.server.protocol.http.parser.*;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class BootStrap {
    public static void main(String[] args) throws IOException {
        EventListener<Connection> socketEventListener =
                new ConnectionEventListener(new EchoEventHandler());
        SocketConnector connector = SocketConnectorFactory.build(18080, socketEventListener);
/*
        EventListener<Connection> socketEventListener2 =
                new ConnectionEventListener(new FileEventHandler(System.getProperty("user.dir")));
        SocketConnector connector2 =
                SocketConnectorFactory.build(18081, socketEventListener2);*/

        EventListener<Connection> socketEventListener3 =
                new ConnectionEventListener(new HttpStaticResourceEventHandler(System.getProperty("user.dir"),
                        new DefaultHttpRequestMessageParser(new DefaultHttpRequestLineParser(),
                                new DefaultHttpQueryParameterParser(),
                                new DefaultHttpHeaderParser(),
                                new DefaultHttpBodyParser())));
        SocketConnector connector3 =
                SocketConnectorFactory.build(18083, socketEventListener3);

        /*EventListener<SelectionKey> nioEventListener = new SelectableChannleEventListener(new NIOEchoEventHandler());
        SocketChannelConnector socketChannelConnector = new SocketChannelConnector(18082, nioEventListener);*/


        ServerConfig serverConfig = ServerConfig.builder()
              //  .addConnector(connector)
                //.addConnector(connector2)
                .addConnector(connector3)
                //.addConnector(socketChannelConnector)
                .build();
        Server server = ServerFactory.getServer(serverConfig);
        server.start();
    }
}
