package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;

import java.io.UnsupportedEncodingException;
import java.net.URI;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 * <p>
 * Method SP Request-URI SP HTTP-Version CRLF
 */
public class DefaultHttpRequestLineParser extends AbstractParser implements HttpRequestLineParser {
    private static final String SPLITTER = "\\s+";

    @Override
    public RequestLine parse() {
        try {
            byte[] bytes = HttpParserContext.getHttpMessageBytes();
            String httpString = new String(bytes, "utf-8");
            String startLine = httpString.split(CRLF, 1)[0];
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
        } catch (UnsupportedEncodingException e) {
            throw new ParserException("Unsupported Encoding", e);
        }
        //如果不满足RequestLine的格式，抛出异常
        throw new ParserException("startline format illegal");
    }
}
