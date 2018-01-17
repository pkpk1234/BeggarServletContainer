package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.*;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
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
        RequestLine requestLine = parseRequestLine(inputStream);

        HttpQueryParameters httpQueryParameters = parseHttpQueryParameters(inputStream);

        IMessageHeaders messageHeaders = parseRequestHeaders(inputStream);

        Optional<HttpBody<?>> httpBody = parseRequestBody(inputStream);
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(requestLine, messageHeaders, httpBody, httpQueryParameters);
        return httpRequestMessage;
    }

    protected abstract RequestLine parseRequestLine(InputStream inputStream);

    protected abstract IMessageHeaders parseRequestHeaders(InputStream inputStream);

    protected abstract Optional<HttpBody<?>> parseRequestBody(InputStream inputStream);

    protected abstract HttpQueryParameters parseHttpQueryParameters(InputStream inputStream);

}
