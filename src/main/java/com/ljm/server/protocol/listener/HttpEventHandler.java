package com.ljm.server.protocol.listener;

import com.ljm.server.demo.FileTransfer;
import com.ljm.server.event.handler.AbstractEventHandler;
import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.parser.AbstractHttpRequestMessageParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class HttpEventHandler extends AbstractEventHandler<Connection> {

    private final String docBase;
    private final FileTransfer fileTransfer = new FileTransfer();
    private final AbstractHttpRequestMessageParser httpRequestMessageParser;

    public HttpEventHandler(String docBase, AbstractHttpRequestMessageParser httpRequestMessageParser) {
        this.docBase = docBase;
        this.httpRequestMessageParser = httpRequestMessageParser;
    }

    @Override
    protected void doHandle(Connection connection) {

        try {
            HttpRequestMessage httpRequestMessage = httpRequestMessageParser.parse(connection.getInputStream());
            
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

    /**
     * 返回文件
     *
     * @param inputstream
     * @param outputStream
     */
    private void getFile(String docBase, InputStream inputstream,
                         OutputStream outputStream) {
        fileTransfer.getFile(docBase, inputstream, outputStream);
    }

}
