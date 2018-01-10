package com.ljm.server.io.connector;

import com.ljm.server.io.connection.Connection;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public abstract class AbstractConnector implements Connector {
    @Override
    public void start() {
        init();
        acceptConnect();
    }

    protected abstract void init() throws ConnectorException;

    protected abstract void acceptConnect() throws ConnectorException;

    protected abstract void communicate(Connection connection) throws ConnectorException;
}
