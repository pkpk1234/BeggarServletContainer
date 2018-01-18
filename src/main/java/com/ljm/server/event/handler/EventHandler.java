package com.ljm.server.event.handler;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public interface EventHandler<T> {
    /**
     * 处理事件
     * @param obj
     * @throws HandlerException
     */
    void handle(T obj) throws HandlerException;
}
