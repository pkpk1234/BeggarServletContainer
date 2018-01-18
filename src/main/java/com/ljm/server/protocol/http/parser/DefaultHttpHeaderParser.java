package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.header.HttpHeader;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class DefaultHttpHeaderParser extends AbstractColleague implements HttpHeaderParser {
    private static final String SPLITTER = ":";
    private static final String CR = "\r";
    private static final String LF = "\n";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpHeaderParser.class);

    public DefaultHttpHeaderParser(AbstractParserContext abstractParserContext) {
        super(abstractParserContext);
    }

    @Override
    public HttpMessageHeaders parser() throws UnsupportedEncodingException {
        byte[] bytes = super.abstractParserContext.getHttpBytes();
        String httpText = new String(bytes,"utf-8");
       // String textBeforeBody =
        HttpMessageHeaders httpMessageHeaders = new HttpMessageHeaders();
        String[] lines = httpText.split(CR+LF);
        //跳过第一行
        for(int i =1;i<lines.length;i++) {
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
