package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/21
 */
public class TestDefaultHttpBodyParser {

    private static final String BODY = "name=Professional%20Ajax&publisher=Wiley\r\n";

    @Test
    public void test() throws IOException {
        byte[] bytes = BODY.getBytes("utf-8");
        HttpParserContext.setInputStream(
                new ByteArrayInputStream(bytes));
        HttpParserContext.setBodyInfo(
                new BodyInfo("", "", true, bytes.length));
        DefaultHttpBodyParser httpBodyParser
                = new DefaultHttpBodyParser();
        HttpBody httpBody = httpBodyParser.parse();
        byte[] bodyContent =
                IOUtils.readFully(httpBody.getInputStream(), (int) httpBody.getContentLength());
        assertArrayEquals(BODY.getBytes(), bodyContent);
    }
}
