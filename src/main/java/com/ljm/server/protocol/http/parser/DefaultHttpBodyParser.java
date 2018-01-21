package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.ByteContentHttpBody;
import com.ljm.server.protocol.http.body.HttpBody;

import java.util.Arrays;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/21
 */
public class DefaultHttpBodyParser implements HttpBodyParser<byte[]> {
    @Override
    public HttpBody<byte[]> parse() {
        int index = HttpParserContext.getBytesLengthBeforeBody();
        byte[] httpMessageBytes = HttpParserContext.getHttpMessageBytes();
        byte[] body = Arrays.copyOfRange(httpMessageBytes,
                index,
                httpMessageBytes.length);
        ByteContentHttpBody byteContentHttpBody =
                new ByteContentHttpBody(body);
        return byteContentHttpBody;
    }
}
