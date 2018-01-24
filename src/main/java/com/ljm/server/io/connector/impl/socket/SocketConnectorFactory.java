package com.ljm.server.io.connector.impl.socket;

import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connection.Connection;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketConnectorFactory {

    public static SocketConnector build(SocketConnectorConfig socketConnectorConfig, EventListener<Connection> eventListener) {
        return new SocketConnector(socketConnectorConfig.getPort(),
                socketConnectorConfig.getHost(), socketConnectorConfig.getBackLog(), eventListener);
    }

    public static SocketConnector build(int port, EventListener<Connection> eventListener) {
        return new SocketConnector(port, eventListener);
    }

}
