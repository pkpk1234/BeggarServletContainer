package com.ljm.server.protocol.http;

import com.ljm.server.protocol.http.header.HttpMessageHeaders;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpHeaderParser {
    HttpMessageHeaders parser();
}
