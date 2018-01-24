package com.ljm.server.com.ljm.server.protocol.http.response;

import com.ljm.server.protocol.http.HttpResponseMessage;
import com.ljm.server.protocol.http.ResponseLine;
import com.ljm.server.protocol.http.header.HttpHeader;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import com.ljm.server.protocol.http.header.IMessageHeaders;
import com.ljm.server.protocol.http.response.HttpResponseMessageBuilder;
import org.junit.Test;
import sun.net.www.MimeTable;

import javax.activation.MimetypesFileTypeMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018/1/22
 */
public class TestHttpResponseMessageBuilder {
    @Test
    public void test() {
        IMessageHeaders messageHeaders = new HttpMessageHeaders();
        messageHeaders.addHeader(new HttpHeader("Content-Type", "plain/html"));
        HttpResponseMessage result = HttpResponseMessageBuilder.builder()
                .withResponseLine(new ResponseLine("HTTP/1.1", 200, "OK"))
                .withMessageHeaders(messageHeaders).build();
        assertNotNull(result);
        assertEquals("plain/html",
                result.getMessageHeaders().getFirstHeader("Content-Type").getValue());
    }

    @Test
    public void test2() throws IOException {
        System.out.println(Files.probeContentType(Paths.get("", ".js")));
        System.out.println(Files.probeContentType(Paths.get("", ".html")));
    }
}
