package com.ljm.server.event;

import com.ljm.server.handler.EventHandler;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public abstract class AbstractEventListener<T> implements EventListener<T> {
    @Override
    public void onEvent(T event) throws EventException {
        EventHandler<T> eventHandler = getEventHandler(event);
        eventHandler.handle(event);
    }

    protected abstract EventHandler<T> getEventHandler(T event);
}
