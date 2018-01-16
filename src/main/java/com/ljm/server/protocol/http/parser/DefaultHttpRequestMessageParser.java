package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.*;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class DefaultHttpRequestMessageParser extends AbstractHttpRequestMessageParser {
    private final RequestLineParser requestLineParser;

    public DefaultHttpRequestMessageParser(RequestLineParser requestLineParser) {
        this.requestLineParser = requestLineParser;
    }

    @Override
    protected RequestLine parseRequestLine(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String startLine = scanner.nextLine();
        return this.requestLineParser.parse(startLine);
    }

    @Override
    protected IMessageHeaders parseRequestHeaders(InputStream inputStream) {
        return null;
    }

    @Override
    protected Optional<HttpBody<?>> parseRequestBody(InputStream inputStream) {
        return Optional.empty();
    }

    @Override
    protected HttpQueryParameters parseHttpQueryParameters(InputStream inputStream) {
        return null;
    }
}
