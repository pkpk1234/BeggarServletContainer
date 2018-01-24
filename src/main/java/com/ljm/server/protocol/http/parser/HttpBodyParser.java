package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpBodyParser {
    /**
     * 解析并构建HttpBody对象
     *
     * @return
     */
    HttpBody parse();

}
