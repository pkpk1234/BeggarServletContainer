package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpRequestParameter;
import com.ljm.server.protocol.http.HttpRequestParameterParser;
import com.ljm.server.protocol.http.HttpRequestParameters;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class DefaultHttpRequestParameterParser implements HttpRequestParameterParser {
    private final HttpRequestParameters httpRequestParameters;
    private static final String SPLITTER = "&";
    private static final String KV_SPLITTER = "=";

    public DefaultHttpRequestParameterParser() {
        this.httpRequestParameters = new HttpRequestParameters();
    }

    @Override
    public HttpRequestParameters parse(String queryString) {
        if (queryString.contains(SPLITTER)) {
            String[] keyValues = queryString.split(SPLITTER);
            for (String keyValue : keyValues) {
                if (keyValue.contains(KV_SPLITTER)) {
                    String[] temp = keyValue.split(KV_SPLITTER);
                    if (temp.length == 2) {
                        this.httpRequestParameters
                                .addRequestParameter(new HttpRequestParameter(temp[0], temp[1]));
                    }

                }
            }
        }
        return this.httpRequestParameters;
    }
}
