package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpBodyParser<T> {
    /**
     * 解析并构建HttpBody对象
     * @param bodyBytes
     * @param contentType
     * @return
     * @throws IOException
     */
    HttpBody<T> parse(byte[] bodyBytes, String contentType) throws IOException;

    /**
     * 解析并构建HttpBody对象
     * @param bodyBytes
     * @param contentType
     * @param encoding
     * @return
     * @throws IOException
     */
    HttpBody<T> parse(byte[] bodyBytes, String contentType, String encoding) throws IOException;
}
