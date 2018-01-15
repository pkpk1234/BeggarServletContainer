package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class TestDefaultRequestLineParser {
    private static final Logger
            LOGGER = LoggerFactory.getLogger(TestDefaultRequestLineParser.class);

    @Test
    public void test() {
        DefaultRequestLineParser defaultRequestLineParser
                = new DefaultRequestLineParser();
        RequestLine result = defaultRequestLineParser.parse(
                "GET /hello.txt HTTP/1.1\n" +
                        "User-Agent: curl/7.16.3 libcurl/7.16.3 OpenSSL/0.9.7l zlib/1.2.3\n" +
                        "Host: www.example.com\n" +
                        "Accept-Language: en, mi");
        String method = result.getMethod();
        assertEquals("GET", method);
    }
}
