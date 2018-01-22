package com.ljm.server.protocol.http.response;

import com.ljm.server.io.connection.Connection;
import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.ResponseLine;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
		outputStream.write(responseLineString.getBytes("utf-8"));
		IMessageHeaders headers = httpResponseMessage.getMessageHeaders();
		String headersString = headers.asString();
		outputStream.write(headersString.getBytes("utf-8"));
		Optional<HttpBody> opHttpBody = httpResponseMessage.getHttpBody();
		if (opHttpBody.isPresent()) {
			outputStream.write("\r\n".getBytes("utf-8"));
			outputStream.write(opHttpBody.get().getContent());
		}
		outputStream.flush();
	}
}
