package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import  static com.ljm.server.protocol.http.HttpConstants.*;
/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 * <p>
 * Method SP Request-URI SP HTTP-Version CRLF
 */
public class DefaultHttpRequestLineParser implements HttpRequestLineParser {
    private static final String SPLITTER = "\\s+";

    @Override
    public RequestLine parse() {
        String exceptionMsg = "startline format illegal:";
        try {
            byte[] bytes = HttpParserContext.getHttpMessageBytes();
            String httpString = new String(bytes, "utf-8");
            //按CRLF将字符串拆分为长度为2的数组，取第一个值即为startLine
            String startLine = httpString.split(CRLF, 2)[0];
            //去掉末尾的CRLF和空格，转化为Method SP Request-URI SP HTTP-Version
            String str = startLine.replaceAll(CRLF, "").trim();
            String[] parts = str.split(SPLITTER);
            //数组格式{Method,Request-URI,HTTP-Version}
            if (parts.length == 3) {
                String method = parts[0];
                URI uri = URI.create(parts[1]);
                HttpParserContext.setRequestQueryString(uri.getQuery());
                String httpVersion = parts[2];
                return new RequestLine(method, uri, httpVersion);
            }
            exceptionMsg += startLine;
        } catch (UnsupportedEncodingException e) {
            throw new ParserException("Unsupported Encoding", e);
        }
        //如果不满足RequestLine的格式，抛出异常
        throw new ParserException(exceptionMsg);
    }
}
