package com.ljm.server.protocol.http.parser;

/**
 * @author 李佳明 https://github.com/pkpk1234
 */
public abstract class AbstractParser {
    protected static final String KV_SPLITTER = "=";
    protected HttpParserContext httpParserContext;
    protected final String CRLF = "\r\n";

    public AbstractParser(HttpParserContext httpParserContext) {
        this.httpParserContext = httpParserContext;
    }
}
