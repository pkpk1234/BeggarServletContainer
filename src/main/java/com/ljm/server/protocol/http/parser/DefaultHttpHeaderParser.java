package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpHeader;
import com.ljm.server.protocol.http.HttpHeaderParser;
import com.ljm.server.protocol.http.header.HttpMessageHeaders;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/16
 */
public class DefaultHttpHeaderParser implements HttpHeaderParser {
    private static final String SPLITTER = ":";
    private static final String CR = "\r";
    private static final String LF = "\n";

    @Override
    public HttpMessageHeaders parser(InputStream inputStream) {
        HttpMessageHeaders httpMessageHeaders = new HttpMessageHeaders();
        Scanner scanner = new Scanner(inputStream, "utf-8");
        //跳过第一行
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String keyValue = scanner.nextLine();
            //只解析Http Header
            if (keyValue.equals(CR + LF) || keyValue.equals(CR) || keyValue.equals("LF")) {
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
