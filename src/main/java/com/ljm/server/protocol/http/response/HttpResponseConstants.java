package com.ljm.server.protocol.http.response;

import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018/1/22
 */
public interface HttpResponseConstants {
    HttpResponseMessage HTTP_404 = HttpResponseMessageBuilder.builder()
            .withResponseLine(ResponseLineConstants.RES_404)
            .withMessageHeaders(HttpMessageHeaders.newBuilder()
                    .addHeader("Content-Type", "text/html").build())
            .build();
}
