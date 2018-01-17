package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.HttpBodyParser;
import com.ljm.server.protocol.http.HttpBody;
import com.ljm.server.protocol.http.body.StringContentHttpBody;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class StringHttpBodyParser implements HttpBodyParser<String> {
    private static final String CRLF = "\r\n";

    @Override
    public HttpBody<String> parse(InputStream inputStream, String contentType) {
        return this.parse(inputStream, contentType, "UTF-8");
    }

    @Override
    public HttpBody<String> parse(InputStream inputStream, String contentType, String encoding) {
        Scanner sc = new Scanner(inputStream, encoding);
        while (sc.hasNextLine()) {
            if (sc.nextLine().equals("")) {
                break;
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()).append(CRLF);
        }
        return new StringContentHttpBody(buffer.toString(), contentType);
    }
}
