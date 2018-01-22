package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/21
 */
public class DefaultHttpBodyParser implements HttpBodyParser {
    @Override
    public HttpBody parse() {
        int index = HttpParserContext.getBytesLengthBeforeBody();
        byte[] httpMessageBytes = HttpParserContext.getHttpMessageBytes();
        byte[] body = Arrays.copyOfRange(httpMessageBytes,
                index,
                httpMessageBytes.length);
        String contentType = HttpParserContext.getContentType();
        String encoding = getEncoding(contentType);
        HttpBody httpBody =
                new HttpBody(contentType, encoding, body);
        return httpBody;
    }

    private String getEncoding(String contentType) {
        String encoding = "utf-8";
        if (StringUtils.isNotBlank(contentType) && contentType.contains(";")) {
            encoding = contentType.split(";")[1].trim();
        }
        return encoding;
    }
}
