package com.ljm.server.io.connector;

import com.ljm.server.io.connection.Connection;

import java.nio.channels.SelectionKey;

public abstract class AbstractChannelConnector extends AbstractConnector {

    protected abstract void communicate(SelectionKey selectionKey) throws ConnectorException;

    @Override
    protected void communicate(Connection connection) throws ConnectorException {
        throw new ConnectorException("not support BIO.");
    }
}
