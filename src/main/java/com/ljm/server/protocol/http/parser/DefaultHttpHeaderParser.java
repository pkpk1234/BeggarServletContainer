package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpHeader;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class DefaultHttpHeaderParser extends AbstractParser implements HttpHeaderParser {
    private static final String SPLITTER = ":";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpHeaderParser.class);

    @Override
    public HttpMessageHeaders parse() {
        try {
            String httpText = getHttpTextFromContext();
            HttpMessageHeaders httpMessageHeaders = doParseHttpMessageHeaders(httpText);
            setHasBody(httpMessageHeaders);
            return httpMessageHeaders;
        } catch (UnsupportedEncodingException e) {
            throw new ParserException("Unsupported Encoding", e);
        }
    }

    /**
     * 从上下文获取bytes并转换为String
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    private String getHttpTextFromContext() throws UnsupportedEncodingException {
        byte[] bytes = HttpParserContext.getHttpMessageBytes();
        return new String(bytes, "utf-8");
    }

    /**
     * 解析Body之前的文本构建HttpHeader，并保存到HttpMessageHeaders中
     *
     * @param httpText
     * @return
     */
    private HttpMessageHeaders doParseHttpMessageHeaders(String httpText) {
        HttpMessageHeaders httpMessageHeaders = new HttpMessageHeaders();
        String[] lines = httpText.split(CRLF);
        //跳过第一行
        for (int i = 1; i < lines.length; i++) {
            String keyValue = lines[i];
            if ("".equals(keyValue)) {
                break;
            }
            String[] temp = keyValue.split(SPLITTER);
            if (temp.length == 2) {
                httpMessageHeaders.addHeader(new HttpHeader(temp[0], temp[1].trim()));
            }
        }
        return httpMessageHeaders;
    }

    /**
     * 设置报文是否包含Body到上下文中
     */
    private void setHasBody(HttpMessageHeaders httpMessageHeaders) {
        if (httpMessageHeaders.hasHeader("Content-Length")
                ) {
            HttpParserContext.setHasBody(true);
            HttpParserContext.getBodyInfo()
                    .setContentLength(Integer.valueOf(httpMessageHeaders.getFirstHeader
                            ("Content-Length").getValue()));
        } else if ((httpMessageHeaders.hasHeader("Transfer-Encoding")
                && "chunked".equals(httpMessageHeaders.getFirstHeader("Transfer-Encoding").getValue()))) {
            HttpParserContext.setHasBody(true);
        }
    }
}
