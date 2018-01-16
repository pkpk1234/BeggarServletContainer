package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;
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
    private final HttpHeaderParser httpHeaderParser;
    private final HttpBodyParser<?> httpBodyParser;
    private final HttpQueryParameterParser httpQueryParameterParser;

    public DefaultHttpRequestMessageParser(RequestLineParser requestLineParser,
                                           HttpHeaderParser httpHeaderParser,
                                           HttpBodyParser<?> httpBodyParser,
                                           HttpQueryParameterParser httpQueryParameterParser) {
        this.requestLineParser = requestLineParser;
        this.httpHeaderParser = httpHeaderParser;
        this.httpBodyParser = httpBodyParser;
        this.httpQueryParameterParser = httpQueryParameterParser;
    }

    @Override
    protected RequestLine parseRequestLine(InputStream inputStream) {
        return getRequestLine(inputStream);
    }

    private RequestLine getRequestLine(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "utf-8");
        String startLine = scanner.nextLine();
        return this.requestLineParser.parse(startLine);
    }

    @Override
    protected IMessageHeaders parseRequestHeaders(InputStream inputStream) {
        return httpHeaderParser.parser(inputStream);
    }
    //TODO: body的解析
    @Override
    protected Optional<HttpBody<?>> parseRequestBody(InputStream inputStream) {
        return Optional.empty();
    }

    @Override
    protected HttpQueryParameters parseHttpQueryParameters(InputStream inputStream) {
        RequestLine requestLine = getRequestLine(inputStream);
        return this.httpQueryParameterParser.parse(requestLine.getRequestURI().getQuery());
    }
}
