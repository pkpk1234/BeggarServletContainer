package com.ljm.server.protocol.http;


import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/12
 */
public class HttpResponse implements HttpMessage {
    private final ResponseLine responseLine;
    private final IMessageHeaders messageHeaders;
    private final HttpBody<?> httpBody;

    public HttpResponse(ResponseLine responseLine,
                        IMessageHeaders messageHeaders, HttpBody httpBody) {
        this.responseLine = responseLine;
        this.messageHeaders = messageHeaders;
        this.httpBody = httpBody;
    }

    @Override
    public StartLine getStartLine() {
        return StartLine.class.cast(this.responseLine);
    }

    @Override
    public IMessageHeaders getMessageHeaders() {
        return this.messageHeaders;
    }

    @Override
    public Optional<HttpBody> getHttpBody() {
        return Optional.ofNullable(this.httpBody);
    }

    public ResponseLine getResponseLine() {
        return responseLine;
    }
}
