package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;

public class AbstractParserContext {
    protected final RequestLineParser requestLineParser;
    protected final HttpHeaderParser httpHeaderParser;
    protected final HttpBodyParser<?> httpBodyParser;
    protected final HttpQueryParameterParser httpQueryParameterParser;

    public AbstractParserContext(RequestLineParser requestLineParser, HttpHeaderParser httpHeaderParser, HttpBodyParser<?> httpBodyParser, HttpQueryParameterParser httpQueryParameterParser) {
        this.requestLineParser = requestLineParser;
        this.httpHeaderParser = httpHeaderParser;
        this.httpBodyParser = httpBodyParser;
        this.httpQueryParameterParser = httpQueryParameterParser;
    }

    public byte[] getHttpBytes() {
        return null;
    }

    public void setHttpBytes(byte[] bytes) {
    }

    public void setRequestQueryString(String query) {
    }
}
