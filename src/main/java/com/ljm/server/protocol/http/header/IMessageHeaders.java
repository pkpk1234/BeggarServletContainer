package com.ljm.server.protocol.http.header;

import com.ljm.server.protocol.http.header.HttpHeader;

import java.util.List;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface IMessageHeaders {

    List<HttpHeader> getHeader(String headerName);

    HttpHeader getFirstHeader(String headerName);

    List<HttpHeader> getAllHeaders();

    void addHeader(HttpHeader httpHeader);

    void removeHeader(HttpHeader httpHeader);

    void removeHeaders(String headerName);

    boolean hasHeader(String headerName);

    Set<String> getHeaderNames();
}
