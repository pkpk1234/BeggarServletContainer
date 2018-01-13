package com.ljm.server.protocol.http.body;

import com.ljm.server.protocol.http.HttpBody;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class StringContentHttpBody implements HttpBody<String> {
    private final String bodyString;
    private final String contentTyep;

    public StringContentHttpBody(String bodyString, String contentTyep) {
        this.bodyString = bodyString;
        this.contentTyep = contentTyep;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public String getBodyContent() {
        return bodyString;
    }
}
