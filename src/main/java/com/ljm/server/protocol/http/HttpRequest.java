package com.ljm.server.protocol.http;

import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/12
 * <p>
 * HTTP请求
 */
public class HttpRequest implements HttpMessage {
    private final RequestLine requestLine;
    private final IMessageHeaders messageHeaders;
    private final HttpBody<?> httpBody;

    public HttpRequest(RequestLine requestLine,
                       IMessageHeaders messageHeaders, HttpBody<?> httpBody) {
        this.requestLine = requestLine;
        this.messageHeaders = messageHeaders;
        this.httpBody = httpBody;
    }

    @Override
    public StartLine getStartLine() {
        return StartLine.class.cast(this.requestLine);
    }

    @Override
    public IMessageHeaders getMessageHeaders() {
        return this.messageHeaders;
    }

    @Override
    public Optional<HttpBody> getHttpBody() {
        return Optional.ofNullable(this.httpBody);
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }
}
