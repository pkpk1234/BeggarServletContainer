package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpHeader;
import com.ljm.server.protocol.http.HttpHeaderParser;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class DefaultHttpHeaderParser implements HttpHeaderParser {
    private static final String SPLITTER = ":";
    private static final String CR = "\r";
    private static final String LF = "\n";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpHeaderParser.class);
    @Override
    public HttpMessageHeaders parser(String httpText) {
        HttpMessageHeaders httpMessageHeaders = new HttpMessageHeaders();
        String[] lines = httpText.split(CR+LF);
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
        /*Scanner scanner = new Scanner(inputStream, "utf-8");
        //跳过第一行
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String keyValue = scanner.nextLine();
            //只解析Http Header
            if (keyValue.equals("")) {
                break;
            }
            LOGGER.info("key value {}",keyValue);
            String[] temp = keyValue.split(SPLITTER);
            if (temp.length == 2) {
                httpMessageHeaders.addHeader(new HttpHeader(temp[0], temp[1].trim()));
            }
        }*/
        return httpMessageHeaders;
    }
}
