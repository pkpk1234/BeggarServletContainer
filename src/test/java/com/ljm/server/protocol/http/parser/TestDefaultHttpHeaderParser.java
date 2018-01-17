package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class TestDefaultHttpHeaderParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDefaultHttpHeaderParser.class);
    private static final String HTTP_MESSAGE =
            "POST / HTTP1.1\r\n" +
                    "Host:www.wrox.com\r\n" +
                    "User-Agent:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022)\r\n" +
                    "Content-Type:application/x-www-form-urlencoded\r\n" +
                    "Content-Length:40\r\n" +
                    "Connection: Keep-Alive\r\n" +
                    "\r\n" +
                    "name=Professional%20Ajax&publisher=Wiley\r\n" +
                    "\r\n";

    @Test
    public void test() throws UnsupportedEncodingException {
        DefaultHttpHeaderParser defaultHttpHeaderParser
                = new DefaultHttpHeaderParser();

        HttpMessageHeaders result = defaultHttpHeaderParser.parser(HTTP_MESSAGE);
        assertEquals("www.wrox.com", result.getFirstHeader("Host").getValue());
        assertEquals("Keep-Alive", result.getFirstHeader("Connection").getValue());

    }
}
