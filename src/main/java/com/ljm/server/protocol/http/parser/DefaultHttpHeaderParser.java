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
    private static final Pattern BLANK_LINE = Pattern.compile("(?m)^\n");

    public DefaultHttpHeaderParser(AbstractParserContext abstractParserContext) {
        super(abstractParserContext);
    }

    @Override
    public HttpMessageHeaders parser() throws UnsupportedEncodingException {
        byte[] bytes = super.abstractParserContext.getHttpMessageBytes();
        String httpText = new String(bytes, "utf-8");

        Matcher matcher = BLANK_LINE.matcher(httpText);
        if (matcher.find()) {
            int idx = matcher.end();
            super.abstractParserContext.setHasBody(true);
            httpText = httpText.substring(0, idx);
            super.abstractParserContext.setBytesBeforeBody(httpText.getBytes("utf-8").length);
        }

        HttpMessageHeaders httpMessageHeaders = new HttpMessageHeaders();
        String[] lines = httpText.split(CRLF);
        //跳过第一行
        for (int i = 1; i < lines.length; i++) {
            String keyValue = lines[i];
            if (keyValue.equals("")) {
                break;
            }
            String[] temp = keyValue.split(SPLITTER);
            if (temp.length == 2) {
                httpMessageHeaders.addHeader(new HttpHeader(temp[0], temp[1].trim()));
            }
        }
        return httpMessageHeaders;
    }
}
