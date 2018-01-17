package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public abstract class AbstractHttpRequestMessageParser implements HttpRequestMessageParser {

    /**
     * 定义parse流程
     *
     * @return
     */
    @Override
    public HttpMessage parse(InputStream inputStream) throws IOException {
        String httpRequestString = IOUtils.toString(inputStream, "utf-8");
        RequestLine requestLine = parseRequestLine(httpRequestString);

        HttpQueryParameters httpQueryParameters = parseHttpQueryParameters(requestLine);

        IMessageHeaders messageHeaders = parseRequestHeaders(httpRequestString);

        Optional<HttpBody<?>> httpBody = parseRequestBody(inputStream);
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(requestLine, messageHeaders, httpBody, httpQueryParameters);
        return httpRequestMessage;
    }

    protected abstract RequestLine parseRequestLine(String inputStream);

    protected abstract IMessageHeaders parseRequestHeaders(String inputStream);

    protected abstract Optional<HttpBody<?>> parseRequestBody(InputStream inputStream);

    protected abstract HttpQueryParameters parseHttpQueryParameters(RequestLine requestLine);

}
