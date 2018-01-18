package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface RequestLineParser {
    /**
     * 解析start line，并返回RequestLine对象
     *
     * Method SP Request-URI SP HTTP-Version CRLF
     * @param startLine
     * @return
     */
    RequestLine parse(String startLine);
}
