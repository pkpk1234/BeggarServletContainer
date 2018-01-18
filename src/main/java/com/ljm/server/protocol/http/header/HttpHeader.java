package com.ljm.server.protocol.http.header;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 * <p>
 * HTTP 头
 */
public class HttpHeader {
    private final String name;
    private final String value;

    public HttpHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
