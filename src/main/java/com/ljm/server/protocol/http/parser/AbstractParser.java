package com.ljm.server.protocol.http.parser;


public abstract class AbstractParser {
    protected static final String KV_SPLITTER = "=";
    protected HttpParserContext httpParserContext;
    protected final String CRLF = "\r\n";

    public AbstractParser(HttpParserContext httpParserContext) {
        this.httpParserContext = httpParserContext;
    }
}
