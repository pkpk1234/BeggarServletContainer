package com.ljm.server.event.listener;

import com.ljm.server.event.EventException;
import com.ljm.server.event.handler.EventHandler;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public abstract class AbstractEventListener<T> implements EventListener<T> {
    /**
     * 事件处理流程模板方法
     * @param event 事件对象
     * @throws EventException
     */
    @Override
    public void onEvent(T event) throws EventException {
        EventHandler<T> eventHandler = getEventHandler(event);
        eventHandler.handle(event);
    }

    /**
     * 返回事件处理器
     * @param event
     * @return
     */
    protected abstract EventHandler<T> getEventHandler(T event);
}
