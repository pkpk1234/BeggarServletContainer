package com.ljm.server.io;

import com.ljm.server.LifeCycle;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public abstract class AbstractConnector<T> implements Connector,LifeCycle {
    @Override
    public void start() {
        init();
        acceptConnect();
    }

    protected abstract void init() throws ConnectorException;

    protected abstract void acceptConnect() throws ConnectorException;

    protected abstract void whenAccept(T connect) throws ConnectorException;
}
