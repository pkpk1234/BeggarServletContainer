package com.ljm.server.io.impl.socket;

import com.ljm.server.event.impl.SocketEventListener;
import com.ljm.server.io.Connector;
import com.ljm.server.io.ConnectorFactory;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketConnectorFactory implements ConnectorFactory {
    private final SocketConnectorConfig socketConnectorConfig;
    private final SocketEventListener socketEventListener;

    public SocketConnectorFactory(SocketConnectorConfig socketConnectorConfig, SocketEventListener socketEventListener) {
        this.socketConnectorConfig = socketConnectorConfig;
        this.socketEventListener = socketEventListener;
    }

    @Override
    public Connector getConnector() {
        return new SocketConnector(this.socketConnectorConfig.getPort(), socketEventListener);
    }
}
