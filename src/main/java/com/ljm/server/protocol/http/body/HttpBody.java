package com.ljm.server.protocol.http.body;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface HttpBody<T> {
    String getContentType();
    T getBodyContent();
}
