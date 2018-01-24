package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpMessageHeaders;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpHeaderParser {
    /**
     * 解析并返回HttpMessageHeader集合
     *
     * @return
     */
    HttpMessageHeaders parse();
}
