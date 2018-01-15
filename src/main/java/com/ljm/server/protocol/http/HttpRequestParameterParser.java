package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public interface HttpRequestParameterParser {
    HttpRequestParameters parse(String queryString);
}
