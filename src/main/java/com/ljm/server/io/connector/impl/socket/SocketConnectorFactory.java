package com.ljm.server.io.connector.impl.socket;

import com.ljm.server.io.connection.Connection;
import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connector.AbstractConnector;
import com.ljm.server.io.connector.ConnectorFactory;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketConnectorFactory implements ConnectorFactory {
    private final SocketConnectorConfig socketConnectorConfig;
    private final EventListener<Connection> eventListener;

    public SocketConnectorFactory(SocketConnectorConfig socketConnectorConfig, EventListener<Connection> eventListener) {
        this.socketConnectorConfig = socketConnectorConfig;
        this.eventListener = eventListener;
    }

    @Override
    public AbstractConnector getConnector() {
        return new SocketConnector(this.socketConnectorConfig.getPort(), eventListener);
    }
}
