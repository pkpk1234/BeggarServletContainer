package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;

public class DefaultHttpParserContext extends AbstractParserContext {

    protected byte[] httpMessageBytes;
    protected String requestQueryString;
    protected boolean hasBody;
    protected int bytesBeforeBody;

    public DefaultHttpParserContext(RequestLineParser requestLineParser,
                                    HttpHeaderParser httpHeaderParser,
                                    HttpBodyParser<?> httpBodyParser,
                                    HttpQueryParameterParser httpQueryParameterParser) {
        super(requestLineParser, httpHeaderParser, httpBodyParser, httpQueryParameterParser);
    }

    @Override
    public byte[] getHttpMessageBytes() {
        return this.httpMessageBytes;
    }

    @Override
    public void setHttpMessageBytes(byte[] bytes) {
        this.httpMessageBytes = bytes;
    }

    @Override
    public void setRequestQueryString(String queryString) {
        this.requestQueryString = queryString;
    }

    @Override
    public void setHasBody(boolean hasBody) {
        this.hasBody = hasBody;
    }

    @Override
    public void setBytesBeforeBody(int bytesBeforeBody) {
        this.bytesBeforeBody = bytesBeforeBody;
    }
}
