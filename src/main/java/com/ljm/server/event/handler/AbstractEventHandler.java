package com.ljm.server.event.handler;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public abstract class AbstractEventHandler<T> implements EventHandler<T> {
    @Override
    public void handle(T obj) throws HandlerException {
        beforeHandle(obj);
        doHandle(obj);
        afterHandle(obj);
    }

    protected void beforeHandle(T obj) {
    }

    protected abstract void doHandle(T obj);

    protected void afterHandle(T obj) {
    }


}
