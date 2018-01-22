package com.ljm.server.protocol.http.handler;

import com.ljm.server.demo.FileTransfer;
import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.parser.AbstractHttpRequestMessageParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        String path = httpRequestMessage.getRequestLine().getRequestURI().getPath();
        Path filePath = Paths.get(docBase, path);
        if (Files.isDirectory(filePath)) {
            //TODO: 404
        } else {

        }
        return null;
    }

    @Override
    protected void doTransferToClient(HttpResponseMessage responseMessage) {

    }


}
