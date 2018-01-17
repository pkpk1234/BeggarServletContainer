package com.ljm.server.protocol;

import com.ljm.server.protocol.http.HttpBody;

import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpBodyParser<T> {
    HttpBody<T> parse(InputStream inputStream, String contentType);

    HttpBody<T> parse(InputStream inputStream, String contentType, String encoding);
}
