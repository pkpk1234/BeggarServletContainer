package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface RequestLineParser {
    RequestLine parse(String startLine);
}
