package com.ljm.server.event.impl;

import com.ljm.server.event.AbstractEventListener;
import com.ljm.server.handler.EventHandler;

import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketEventListener extends AbstractEventListener<Socket> {

    private final EventHandler<Socket> eventHandler;

    public SocketEventListener(EventHandler<Socket> eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    protected EventHandler<Socket> getEventHandler(Socket event) {
        return eventHandler;
    }
}
