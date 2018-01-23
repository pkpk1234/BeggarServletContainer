package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
                    "name=Professional%20Ajax&publisher=Wiley\r\n";

    @Test
    public void testRegex() {
        String regex = "(?m)^\r\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(HTTP_MESSAGE);
        if (matcher.find()) {
            int end = matcher.end();
            LOGGER.info("" + end);
            LOGGER.info("rest {} ----", HTTP_MESSAGE.substring(0, end));
        }

    }

    @Test
    public void test() throws UnsupportedEncodingException {
        HttpParserContext context = new HttpParserContext();
        DefaultHttpHeaderParser httpHeaderParser = new DefaultHttpHeaderParser();
        context.setHttpMessageBytes(HTTP_MESSAGE.getBytes("utf-8"));
        HttpMessageHeaders httpHeaders = httpHeaderParser.parse();
        assertTrue(httpHeaders.hasHeader("Host"));
        assertEquals("40", httpHeaders.getFirstHeader("Content-Length").getValue());
    }
}
