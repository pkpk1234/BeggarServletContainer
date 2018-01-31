package com.ljm.server.com.ljm.server.protocol.http.body;

import com.ljm.server.protocol.http.body.HttpBodyInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/30
 */
public class TestHttpBodyInputStream {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestHttpBodyInputStream.class);
    /*
        7
        Mozilla
        9
        Developer
        7
        Network
        0

     */
    private static final String TEST_OTHER_MESSAGE = "testtest";
    private static final String CHUNKED_BODY = "7\r\n" +
            "Mozilla\r\n" +
            "9\r\n" +
            "Developer\r\n" +
            "7\r\n" +
            "Network\r\n" +
            "0\r\n" +
            "\r\n";

    private static final String BODY = CHUNKED_BODY + TEST_OTHER_MESSAGE;

    private static final String NORMAL_BODY = "Mozilla Developer Network";

    @Test
    public void testReadChunkedBody() throws IOException {
        InputStream in = new ByteArrayInputStream(BODY.getBytes());
        HttpBodyInputStream httpBodyInputStream = new HttpBodyInputStream(in, true);
        ByteOutputStream out = new ByteOutputStream();
        IOUtils.copy(httpBodyInputStream, out);
        LOGGER.info(out.toString());
        assertEquals(CHUNKED_BODY, out.toString());
    }

    @Test
    public void testReadBody() throws IOException {
        InputStream in = new ByteArrayInputStream(NORMAL_BODY.getBytes());
        HttpBodyInputStream httpBodyInputStream = new HttpBodyInputStream(in, false);
        httpBodyInputStream.setContentLength(25);
        ByteOutputStream out = new ByteOutputStream();
        IOUtils.copy(httpBodyInputStream, out);
        LOGGER.info(out.toString());
        assertEquals(NORMAL_BODY, out.toString());
    }
}
