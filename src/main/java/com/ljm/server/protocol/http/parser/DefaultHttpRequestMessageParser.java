package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;
import com.ljm.server.protocol.http.*;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class DefaultHttpRequestMessageParser  {

    /*@Override
    protected RequestLine parseRequestLine(String httpText) {
        return this.requestLineParser.parse(httpText.split("\r\n")[0]);
        //return getRequestLine(inputStream);
    }

    private RequestLine getRequestLine(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "utf-8");
        String startLine = scanner.nextLine();
        return this.requestLineParser.parse(startLine);
    }

    @Override
    protected IMessageHeaders parseRequestHeaders(String httpText) {
        return httpHeaderParser.parser(httpText);
    }

    //TODO: body的解析
    @Override
    protected Optional<HttpBody<?>> parseRequestBody(String httpText, IMessageHeaders messageHeaders) {
        return Optional.empty();
    }

    @Override
    protected HttpQueryParameters parseHttpQueryParameters(RequestLine requestLine) {
        return this.httpQueryParameterParser.parse(requestLine.getRequestURI().getQuery());
    }*/
}
