package com.ljm.server.protocol.http;

import com.ljm.server.protocol.Protocol;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class HttpProtocol implements Protocol {
    private final String name = "http";
    private final String version;

    private HttpProtocol(String version) {
        this.version = version;
    }

    public static final HttpProtocol VERSION11 = new HttpProtocol("1.1");
    public static final HttpProtocol VERSION20 = new HttpProtocol("2.0");

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String version() {
        return this.version;
    }

    @Override
    public String toString() {
        return this.name + "/" + this.version;
    }
}
