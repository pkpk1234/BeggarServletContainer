package com.ljm.server.protocol.http.handler;

import com.ljm.server.demo.FileTransfer;
import com.ljm.server.event.handler.AbstractEventHandler;
import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.parser.AbstractHttpRequestMessageParser;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class HttpStaticResourceEventHandler extends AbstractEventHandler<Connection> {

    private final String docBase;
    private final FileTransfer fileTransfer = new FileTransfer();
    private final AbstractHttpRequestMessageParser httpRequestMessageParser;

    public HttpStaticResourceEventHandler(String docBase, AbstractHttpRequestMessageParser httpRequestMessageParser) {
        this.docBase = docBase;
        this.httpRequestMessageParser = httpRequestMessageParser;
    }

    @Override
    protected void doHandle(Connection connection) {

        try {
            HttpRequestMessage httpRequestMessage = httpRequestMessageParser.parse(connection.getInputStream());
            String path = httpRequestMessage.getRequestLine().getRequestURI().getPath();

        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }


}
