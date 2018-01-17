package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.BodyParserFactory;
import com.ljm.server.protocol.HttpBodyParser;

/**
 * @author l00388716
 * Date: 2018/1/17
 * Time: 9:35
 * Description:
 */
public class HttpBodyParserFactory implements BodyParserFactory {
    @Override
    public HttpBodyParser<?> createHttpBodyParser(String contentType) {
        return this.createHttpBodyParser(contentType, "UTF-8");
    }

    @Override
    public HttpBodyParser<?> createHttpBodyParser(String contentType, String encoding) {
        
        return null;
    }
}
