package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/21
 */
public class TestDefaultHttpBodyParser {
    private static final String MESSAGE_BEFORE_BODY =
            "POST / HTTP1.1\r\n" +
                    "Host:www.wrox.com\r\n" +
                    "User-Agent:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022)\r\n" +
                    "Content-Type:application/x-www-form-urlencoded\r\n" +
                    "Content-Length:40\r\n" +
                    "Connection: Keep-Alive\r\n" +
                    "\r\n";
    private static final String BODY = "name=Professional%20Ajax&publisher=Wiley\r\n";
    private static final String HTTP_MESSAGE = MESSAGE_BEFORE_BODY + BODY;

    @Test
    public void test() {
        HttpParserContext.setHttpMessageBytes(HTTP_MESSAGE.getBytes());
        HttpParserContext.setBytesLengthBeforeBody(MESSAGE_BEFORE_BODY.getBytes().length);
        DefaultHttpBodyParser httpBodyParser
                = new DefaultHttpBodyParser();
        HttpBody bodyBytes = httpBodyParser.parse();
        assertArrayEquals(BODY.getBytes(), bodyBytes.getContent());
    }
}
