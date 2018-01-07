package com.ljm.server.event;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public interface EventListener<T> {
    /**
     * 事件发生时回调
     * @param event 事件对象
     */
    void onEvent(T event);
}
