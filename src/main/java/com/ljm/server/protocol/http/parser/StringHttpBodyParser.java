package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class StringHttpBodyParser implements HttpBodyParser<String> {


    @Override
    public HttpBody<String> parse(byte[] bodyBytes, String contentType) throws IOException {
        return null;
    }

    @Override
    public HttpBody<String> parse(byte[] bodyBytes, String contentType, String encoding) throws IOException {
        return null;
    }
}
