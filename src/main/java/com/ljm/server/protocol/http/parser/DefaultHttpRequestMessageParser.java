package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpBody;
import com.ljm.server.protocol.http.HttpQueryParameters;
import com.ljm.server.protocol.http.IMessageHeaders;
import com.ljm.server.protocol.http.RequestLine;

import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class DefaultHttpRequestMessageParser extends AbstractHttpRequestMessageParser {

    @Override
    protected RequestLine parseRequestLine() {
        return null;
    }

    @Override
    protected HttpQueryParameters parseHttpRequestParameters() {
        return null;
    }

    @Override
    protected IMessageHeaders parseRequestHeaders() {
        return null;
    }

    @Override
    protected Optional<HttpBody<?>> parseRequestBody() {
        return Optional.empty();
    }


}
