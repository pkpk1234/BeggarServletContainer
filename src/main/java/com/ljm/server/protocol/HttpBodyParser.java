package com.ljm.server.protocol;

import com.ljm.server.protocol.http.HttpBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpBodyParser<T> {
    HttpBody<T> parse(InputStream inputStream, String contentType) throws IOException;

    HttpBody<T> parse(InputStream inputStream, String contentType, String encoding) throws IOException;
}
