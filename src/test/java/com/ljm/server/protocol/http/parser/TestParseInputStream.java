package com.ljm.server.protocol.http.parser;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TestParseInputStream {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestParseInputStream.class);
    private static final String HTTP_MESSAGE =
            "POST / HTTP1.1\r\n" +
                    "Host:www.wrox.com\r\n" +
                    "User-Agent:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022)\r\n" +
                    "Content-Type:application/json\r\n" +
                    "Connection: Keep-Alive\r\n\r\n";

    @Test
    public void test() throws UnsupportedEncodingException {
        InputStream inputStream = new ByteArrayInputStream(HTTP_MESSAGE.getBytes("UTF-8"));
        ParseInputStream parseInputStream = new ParseInputStream(inputStream);
        Scanner sc = new Scanner(parseInputStream, "UTF-8");
        String stringBeforeBody = sc.findWithinHorizon(".+\r\n\r\n", 0);
        LOGGER.info("read count {}",parseInputStream.getReadCount());
        LOGGER.info("stringBeforeBody length {}",HTTP_MESSAGE.getBytes("UTF-8").length);
    }
}
