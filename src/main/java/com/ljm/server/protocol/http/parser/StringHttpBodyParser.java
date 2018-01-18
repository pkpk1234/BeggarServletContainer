package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;
import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.body.StringContentHttpBody;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class StringHttpBodyParser implements HttpBodyParser<String> {

    @Override
    public HttpBody<String> parse(InputStream inputStream, String contentType) throws IOException {
        return this.parse(inputStream, contentType, "UTF-8");
    }

    @Override
    public HttpBody<String> parse(InputStream inputStream, String contentType, String encoding) throws IOException {
        Scanner sc = new Scanner(inputStream, encoding);
        String stringBeforeBody = sc.findWithinHorizon(".+\r\n\r\n", 0);

        BufferedInputStream in = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);

        byte[] buf = new byte[64];
        int readCount = -1;
        while ((readCount = in.read(buf, 0, buf.length)) != -1) {
            byteArrayOutputStream.write(buf, 0, readCount);
        }
        return new StringContentHttpBody(byteArrayOutputStream.toString(encoding), contentType);
    }
}
