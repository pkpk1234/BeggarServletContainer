package com.ljm.server.io.event.listener.impl;

import com.ljm.server.event.handler.EventHandler;
import com.ljm.server.event.listener.AbstractEventListener;
import com.ljm.server.io.connection.Connection;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class ConnectionEventListener extends AbstractEventListener<Connection> {

    private final EventHandler<Connection> eventHandler;

    public ConnectionEventListener(EventHandler<Connection> eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    protected EventHandler<Connection> getEventHandler(Connection event) {
        return this.eventHandler;
    }
}
