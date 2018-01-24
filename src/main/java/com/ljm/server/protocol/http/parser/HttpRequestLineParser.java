package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpRequestLineParser {
    /**
     * 解析start line，并返回RequestLine对象
     * <p>
     * Method SP Request-URI SP HTTP-Version CRLF
     *
     * @return
     */
    RequestLine parse();
}
