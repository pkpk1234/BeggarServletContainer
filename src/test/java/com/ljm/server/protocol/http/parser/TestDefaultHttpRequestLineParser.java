package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class TestDefaultHttpRequestLineParser {
    private static final Logger
            LOGGER = LoggerFactory.getLogger(TestDefaultHttpRequestLineParser.class);

    @Test
    public void test() {
        HttpParserContext parserContext = new HttpParserContext();
        parserContext.setHttpMessageBytes("GET /hello.txt HTTP/1.1\r\n".getBytes());
        DefaultHttpRequestLineParser defaultRequestLineParser
                = new DefaultHttpRequestLineParser();

        RequestLine result = defaultRequestLineParser.parse();
        String method = result.getMethod();
        assertEquals("GET", method);
        final URI requestURI = result.getRequestURI();
        assertEquals(URI.create("/hello.txt"), requestURI);
        LOGGER.info(requestURI.getQuery());
        LOGGER.info(requestURI.getFragment());
        assertEquals("HTTP/1.1", result.getHttpVersion());
        assertEquals(requestURI.getQuery(), parserContext.getRequestQueryString());
    }

    @Test
    public void testQuery() {
        HttpParserContext parserContext = new HttpParserContext();
        parserContext.setHttpMessageBytes("GET /test?a=123&a1=1&b=456 HTTP/1.1\r\n".getBytes());

        DefaultHttpRequestLineParser defaultRequestLineParser
                = new DefaultHttpRequestLineParser();
        RequestLine result = defaultRequestLineParser.parse();
        String method = result.getMethod();
        assertEquals("GET", method);
        final URI requestURI = result.getRequestURI();
        assertEquals(URI.create("/test?a=123&a1=1&b=456"), requestURI);
        LOGGER.info(requestURI.getQuery());
        assertEquals("HTTP/1.1", result.getHttpVersion());
    }
}
