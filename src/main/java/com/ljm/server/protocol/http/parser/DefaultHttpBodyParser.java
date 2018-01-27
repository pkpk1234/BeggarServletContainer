package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.body.HttpBody;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/21
 */
public class DefaultHttpBodyParser implements HttpBodyParser {
    @Override
    public HttpBody parse() {
        int contentLength = HttpParserContext.getBodyInfo().getContentLength();
        InputStream inputStream = HttpParserContext.getInputStream();
        try {
            byte[] body = IOUtils.readFully(inputStream, contentLength);
            String contentType = HttpParserContext.getContentType();
            String charset = getCharset(contentType);
            HttpBody httpBody =
                    new HttpBody(contentType, charset, body);
            return httpBody;
        } catch (IOException e) {
            throw new ParserException(e);
        }
    }

    /**
     * 获取encoding
     * 例如：Content-type: application/json; charset=utf-8
     *
     * @param contentType
     * @return
     */
    private String getCharset(String contentType) {
        String charset = "utf-8";
        if (StringUtils.isNotBlank(contentType) && contentType.contains(";")) {
            charset = contentType.split(";")[1].trim().replace("charset=", "");
        }
        return charset;
    }
}
