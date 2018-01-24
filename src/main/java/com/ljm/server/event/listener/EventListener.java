package com.ljm.server.event.listener;

import com.ljm.server.event.EventException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public interface EventListener<T> {
    /**
     * 事件发生时的回调方法
     * @param event 事件对象
     * @throws EventException 处理事件时异常都转换为该异常抛出
     */
    void onEvent(T event) throws EventException;
}
