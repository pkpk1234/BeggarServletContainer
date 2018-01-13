package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface IMessageHeaders {

    Iterable<HttpHeader> getHeader(String headerName);

    Iterable<HttpHeader> getHeaders();

    void addHeader(HttpHeader httpHeader);

    void removeHeader(HttpHeader httpHeader);

    void removeHeaders(String headerName);

    boolean hasHeader(String headerName);

    Iterable<String> getHeaderNames();
}
