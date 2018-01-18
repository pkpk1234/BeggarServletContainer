package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpMessage;
import com.ljm.server.protocol.http.HttpQueryParameters;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.RequestLine;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public abstract class AbstractHttpRequestMessageParser extends AbstractParser implements HttpRequestMessageParser {

    public AbstractHttpRequestMessageParser(HttpParserContext httpParserContext) {
        super(httpParserContext);
    }

    /**
     * 定义parse流程
     *
     * @return
     */
    @Override
    public HttpMessage parse(InputStream inputStream) throws IOException {
        //设置上下文
        getAndSetBytesToContext(inputStream);
        RequestLine requestLine = parseRequestLine();
        HttpQueryParameters httpQueryParameters = parseHttpQueryParameters();
        IMessageHeaders messageHeaders = parseRequestHeaders();
        Optional<HttpBody<?>> httpBody = parseRequestBody();

        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(requestLine, messageHeaders, httpBody, httpQueryParameters);
        return httpRequestMessage;
    }
    
    private void getAndSetBytesToContext(InputStream inputStream) throws IOException {
        byte[] bytes = IOUtils.toByteArray(new InputStreamReader(inputStream), "utf-8");
        super.httpParserContext.setHttpMessageBytes(bytes);
    }

    protected abstract RequestLine parseRequestLine();

    protected abstract IMessageHeaders parseRequestHeaders();

    protected abstract Optional<HttpBody<?>> parseRequestBody();

    protected abstract HttpQueryParameters parseHttpQueryParameters();

}
