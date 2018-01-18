package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpHeader;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class DefaultHttpHeaderParser extends AbstractParser implements HttpHeaderParser {
    private static final String SPLITTER = ":";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpHeaderParser.class);
    private static final Pattern BLANK_LINE = Pattern.compile("(?m)^\r\n");

    public DefaultHttpHeaderParser(HttpParserContext httpParserContext) {
        super(httpParserContext);
    }

    @Override
    public HttpMessageHeaders parse() throws UnsupportedEncodingException {
        String httpText = getHttpTextFromContext();
        httpText = getStringBeforeBody(httpText);
        HttpMessageHeaders httpMessageHeaders = doParseHttpMessageHeaders(httpText);
        return httpMessageHeaders;
    }

    private String getHttpTextFromContext() throws UnsupportedEncodingException {
        byte[] bytes = super.httpParserContext.getHttpMessageBytes();
        return new String(bytes, "utf-8");
    }

    private String getStringBeforeBody(String httpText) throws UnsupportedEncodingException {
        Matcher matcher = BLANK_LINE.matcher(httpText);
        if (matcher.find()) {
            int idx = matcher.end();
            setHasBody();
            httpText = setBytesBeforeBody(httpText, idx);
        }
        return httpText;
    }

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

    private String setBytesBeforeBody(String httpText, int idx) throws UnsupportedEncodingException {
        httpText = httpText.substring(0, idx);
        super.httpParserContext.setBytesLengthBeforeBody(httpText.getBytes("utf-8").length);
        return httpText;
    }

    private void setHasBody() {
        super.httpParserContext.setHasBody(true);
    }
}
