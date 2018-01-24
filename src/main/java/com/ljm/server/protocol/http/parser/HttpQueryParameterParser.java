package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpQueryParameters;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public interface HttpQueryParameterParser {
    /**
     * 解析QueryString，返回HttpQueryParameter集合
     *
     * @return
     */
    HttpQueryParameters parse();
}
