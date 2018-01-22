package com.ljm.server.protocol.http.handler;

import com.ljm.server.demo.FileTransfer;
import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.parser.AbstractHttpRequestMessageParser;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class HttpStaticResourceEventHandler extends AbstractHttpEventHandler {

    private final String docBase;
    private final FileTransfer fileTransfer = new FileTransfer();
    private final AbstractHttpRequestMessageParser httpRequestMessageParser;

    public HttpStaticResourceEventHandler(String docBase, AbstractHttpRequestMessageParser httpRequestMessageParser) {
        this.docBase = docBase;
        this.httpRequestMessageParser = httpRequestMessageParser;
    }

    @Override
    protected HttpRequestMessage doParserRequestMessage(Connection connection) {
        HttpRequestMessage httpRequestMessage = null;
        try {
            httpRequestMessage = httpRequestMessageParser.parse(connection.getInputStream());
        } catch (IOException e) {
            throw new HandlerException(e);
        }
        return httpRequestMessage;
    }

    @Override
    protected HttpResponseMessage doGenerateResponseMessage(HttpRequestMessage httpRequestMessage) {
        return null;
    }

    @Override
    protected void doTransferToClient(HttpResponseMessage responseMessage) {

    }


}
