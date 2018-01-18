package com.ljm.server.protocol.http.parser;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface BodyParserFactory {
    /**
     * 根据contentType构造HttpBodyParser
     *
     * @param contentType
     * @return
     */
    HttpBodyParser<?> createHttpBodyParser(String contentType);

    /**
     * 根据contentType、encoding构造HttpBodyParser
     *
     * @param contentType
     * @param encoding
     * @return
     */
    HttpBodyParser<?> createHttpBodyParser(String contentType, String encoding);
}
