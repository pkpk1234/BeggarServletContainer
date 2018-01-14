package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.*;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public abstract class AbstractHttpRequestMessageParser implements HttpRequestMessageParser {
    @Override
    public HttpMessage parse(InputStream inputStream) {
        RequestLine requestLine = parseRequestLine();
        IMessageHeaders messageHeaders = parseRequestHeaders();
        Optional<HttpBody<?>> httpBody = parseRequestBody();
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(requestLine, messageHeaders, httpBody);
        return httpRequestMessage;
    }

    protected abstract RequestLine parseRequestLine();

    protected abstract IMessageHeaders parseRequestHeaders();

    protected abstract Optional<HttpBody<?>> parseRequestBody();
}
