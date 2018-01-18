package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;

import java.net.URI;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 * <p>
 * Method SP Request-URI SP HTTP-Version CRLF
 */
public class DefaultRequestLineParser extends AbstractParser implements RequestLineParser {
    private static final String SPLITTER = "\\s+";

    @Override
    public RequestLine parse(String startLine) {
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
        throw new ParserException("startline format illegal");
    }
}
