package com.ljm.server.protocol.http.body;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface HttpBody<T> {
    /**
     * 获取HttpBody的Content Type
     *
     * @return
     */
    String getContentType();

    /**
     * 获取HttpBody内容
     *
     * @return
     */
    T getBodyContent();
}
