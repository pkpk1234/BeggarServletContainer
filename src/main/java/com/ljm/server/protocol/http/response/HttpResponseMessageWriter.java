package com.ljm.server.protocol.http.response;

import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.ResponseLine;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-22
 */
public class HttpResponseMessageWriter {
    public void write(HttpResponseMessage httpResponseMessage, Connection connection)
            throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        ResponseLine responseLine = httpResponseMessage.getResponseLine();
        String responseLineString = responseLine.asString();
        write(outputStream, responseLineString);

        IMessageHeaders headers = httpResponseMessage.getMessageHeaders();
        String headersString = headers.asString();
        write(outputStream, headersString);

        Optional<HttpBody> opHttpBody = httpResponseMessage.getHttpBody();
        if (opHttpBody.isPresent()) {

            IOUtils.copy(opHttpBody.get().getInputStream(), outputStream);
        }
        outputStream.flush();
    }

    private void write(OutputStream outputStream, String message) throws IOException {
        outputStream.write(message.getBytes("utf-8"));
        outputStream.write("\r\n".getBytes());
    }
}
