package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.RequestLine;
import com.ljm.server.protocol.http.RequestLineParser;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/14
 */
public class DefaultRequestLineParser implements RequestLineParser {
    private static String REGEX =
            "(GET|PUT|POST|DELETE|HEAD|OPTIONS)\\s+([-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])\\s+(HTTP/\\d\\.\\d)";
    private Pattern pattern;

    public DefaultRequestLineParser() {
        pattern = Pattern.compile(REGEX);
    }

    @Override
    public RequestLine parse(String startLine) {
        Matcher matcher = this.pattern.matcher(startLine);
        int groupCount = matcher.groupCount();
        if (groupCount == 3) {
            String method = matcher.group(0);
            String uriStr = matcher.group(1);
            String httpVersion = matcher.group(2);
            RequestLine requestLine = new RequestLine(method, URI.create(uriStr), httpVersion);
            return requestLine;
        }
        throw new ParserException("request start line illegual");
    }
}
