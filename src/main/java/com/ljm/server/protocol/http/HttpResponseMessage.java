package com.ljm.server.protocol.http;


import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/12
 */
public class HttpResponseMessage implements HttpMessage {
    private final ResponseLine responseLine;
    private final IMessageHeaders messageHeaders;
    private final Optional<HttpBody> httpBody;

    public HttpResponseMessage(ResponseLine responseLine,
                               IMessageHeaders messageHeaders, Optional<HttpBody> httpBody) {
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
        return this.httpBody;
    }

    public ResponseLine getResponseLine() {
        return responseLine;
    }

}
