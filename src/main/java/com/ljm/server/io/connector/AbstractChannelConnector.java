package com.ljm.server.io.connector;

import com.ljm.server.io.connection.Connection;

import java.nio.channels.SelectionKey;

/**
 * ChannelConnector抽象类
 * @author 李佳明 https://github.com/pkpk1234
 */
public abstract class AbstractChannelConnector extends AbstractConnector {
    /**
     * 通过SelectableChannel通信
     * @param selectionKey
     * @throws ConnectorException
     */
    protected abstract void communicate(SelectionKey selectionKey) throws ConnectorException;

    @Override
    protected void communicate(Connection connection) throws ConnectorException {
        throw new ConnectorException("not support BIO.");
    }
}
