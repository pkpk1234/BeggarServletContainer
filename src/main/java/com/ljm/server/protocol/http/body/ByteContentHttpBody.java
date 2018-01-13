package com.ljm.server.protocol.http.body;

import com.ljm.server.protocol.http.HttpBody;

import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class ByteContentHttpBody implements HttpBody<InputStream> {

    public ByteContentHttpBody(String contentType, InputStream inputStream) {
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    private final String contentType;
    private final InputStream inputStream;

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public InputStream getBodyContent() {
        return inputStream;
    }
}
