package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class HttpQueryParameter {
    private final String name;
    private final String value;

    public HttpQueryParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HttpQueryParameter{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
