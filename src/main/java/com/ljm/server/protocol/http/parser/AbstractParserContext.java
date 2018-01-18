package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;

public abstract class AbstractParserContext {
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

    public abstract byte[] getHttpMessageBytes();

    public abstract void setHttpMessageBytes(byte[] bytes);

    public abstract void setRequestQueryString(String queryString);

    public abstract void setHasBody(boolean hasBody);

    public abstract void setBytesBeforeBody(int bytesBeforeBody);
}
