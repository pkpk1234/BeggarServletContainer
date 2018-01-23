package com.ljm.server.protocol.http.handler;

import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpRequestMessage;
import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.ResponseLine;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.HttpHeader;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import com.ljm.server.protocol.http.parser.AbstractHttpRequestMessageParser;
import com.ljm.server.protocol.http.response.HttpResponseConstants;
import com.ljm.server.protocol.http.response.HttpResponseMessageWriter;
import com.ljm.server.protocol.http.response.ResponseLineConstants;

import javax.activation.MimetypesFileTypeMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class HttpStaticResourceEventHandler extends AbstractHttpEventHandler {

    private final String docBase;
    private final AbstractHttpRequestMessageParser httpRequestMessageParser;

    public HttpStaticResourceEventHandler(String docBase,
                                          AbstractHttpRequestMessageParser httpRequestMessageParser) {
        this.docBase = docBase;
        this.httpRequestMessageParser = httpRequestMessageParser;
    }

    @Override
    protected HttpRequestMessage doParserRequestMessage(Connection connection) {
        try {
            HttpRequestMessage httpRequestMessage = httpRequestMessageParser
                    .parse(connection.getInputStream());
            return httpRequestMessage;
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

    @Override
    protected HttpResponseMessage doGenerateResponseMessage(
            HttpRequestMessage httpRequestMessage) {
        String path = httpRequestMessage.getRequestLine().getRequestURI().getPath();
        Path filePath = Paths.get(docBase, path);
        if (Files.isDirectory(filePath)) {
            return HttpResponseConstants.HTTP_404;
        } else {
            ResponseLine ok = ResponseLineConstants.RES_200;

            HttpMessageHeaders headers = HttpMessageHeaders.newBuilder()
                    .addHeader("status", "200").build();
            HttpBody httpBody = null;
            try {
                getContentType(filePath, headers);
                httpBody = new HttpBody(new FileInputStream(filePath.toFile()));
            } catch (FileNotFoundException e) {
                return HttpResponseConstants.HTTP_404;
            } catch (IOException e) {
                throw new HandlerException(e);
            }
            HttpResponseMessage httpResponseMessage = new HttpResponseMessage(ok, headers,
                    Optional.ofNullable(httpBody));
            return httpResponseMessage;
        }

    }

    private void getContentType(Path filePath, HttpMessageHeaders headers) throws IOException {
        //使用Files.probeContentType在mac上总是返回null
        //String contentType = Files.probeContentType(filePath);
        String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(filePath.toString());
        headers.addHeader(new HttpHeader("Content-Type", contentType));
        if (contentType.indexOf("text") == -1) {
            headers.addHeader(new HttpHeader("Content-Length",
                    String.valueOf(filePath.toFile().length())));
        }
    }

    @Override
    protected void doTransferToClient(HttpResponseMessage responseMessage,
                                      Connection connection) throws IOException {
        HttpResponseMessageWriter httpResponseMessageWriter = new HttpResponseMessageWriter();
        httpResponseMessageWriter.write(responseMessage, connection);
    }

}
