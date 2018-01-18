package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpRequestMessageParser {
    HttpMessage parse(InputStream inputStream) throws IOException;
}
