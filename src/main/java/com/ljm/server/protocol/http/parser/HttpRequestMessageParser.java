package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public interface HttpRequestMessageParser {
    /**
     * 解析输入流中的内容，并构建Http Message对象
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    HttpMessage parse(InputStream inputStream) throws IOException;
}
