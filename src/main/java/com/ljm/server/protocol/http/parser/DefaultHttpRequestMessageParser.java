package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpQueryParameters;
import com.ljm.server.protocol.http.RequestLine;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import com.ljm.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class DefaultHttpRequestMessageParser extends AbstractHttpRequestMessageParser {
    private final HttpRequestLineParser httpRequestLineParser;
    private final HttpQueryParameterParser httpQueryParameterParser;
    private final HttpHeaderParser httpHeaderParser;
    private final HttpBodyParserFactory httpBodyParserFactory;

    public DefaultHttpRequestMessageParser(HttpRequestLineParser httpRequestLineParser,
                                           HttpQueryParameterParser httpQueryParameterParser,
                                           HttpHeaderParser httpHeaderParser,
                                           HttpBodyParserFactory httpBodyParserFactory) {
        this.httpRequestLineParser = httpRequestLineParser;
        this.httpQueryParameterParser = httpQueryParameterParser;
        this.httpHeaderParser = httpHeaderParser;
        this.httpBodyParserFactory = httpBodyParserFactory;
    }

    @Override
    protected RequestLine parseRequestLine() {
        return this.httpRequestLineParser.parse();
    }

    @Override
    protected HttpQueryParameters parseHttpQueryParameters() {
        return this.httpQueryParameterParser.parse();
    }

    @Override
    protected IMessageHeaders parseRequestHeaders() {
        HttpMessageHeaders httpMessageHeaders = this.httpHeaderParser.parse();
        if (httpMessageHeaders.hasHeader(CONTENT_TYPE)) {
            HttpParserContext.setContentType(httpMessageHeaders.getFirstHeader(CONTENT_TYPE).getValue());
        } else if(HttpParserContext.getHasBody()) {
            //报文中有Body，但没设置类型
            
        }
        return httpMessageHeaders;
    }

    @Override
    protected Optional<HttpBody<?>> parseRequestBody() {
        return Optional.empty();
    }


}
