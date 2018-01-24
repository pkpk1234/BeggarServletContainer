package com.ljm.server.protocol.http;

import java.net.URI;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 * <p>
 * HTTP Request 请求行
 * 参考https://tools.ietf.org/html/rfc2616#page-31
 * Request-Line   = Method SP Request-URI SP HTTP-Version CRLF
 */
public class RequestLine implements StartLine {
    private final String method;
    private final URI requestURI;
    private final String httpVersion;

    public RequestLine(String method, URI requestURI, String httpVersion) {
        this.method = method;
        this.requestURI = requestURI;
        this.httpVersion = httpVersion;
    }

    public String getMethod() {
        return method;
    }

    public URI getRequestURI() {
        return requestURI;
    }

    @Override
    public String getHttpVersion() {
        return httpVersion;
    }
}
