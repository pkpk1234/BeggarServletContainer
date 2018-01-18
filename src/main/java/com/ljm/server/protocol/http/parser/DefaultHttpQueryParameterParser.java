package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpQueryParameter;
import com.ljm.server.protocol.http.HttpQueryParameters;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class DefaultHttpQueryParameterParser extends AbstractColleague implements HttpQueryParameterParser {
    private final HttpQueryParameters httpQueryParameters;
    private static final String SPLITTER = "&";
    private static final String KV_SPLITTER = "=";

    public DefaultHttpQueryParameterParser(AbstractParserContext abstractParserContext) {
        super(abstractParserContext);
        this.httpQueryParameters = new HttpQueryParameters();
    }

    @Override
    public HttpQueryParameters parse(String queryString) {
        if (queryString.contains(SPLITTER)) {
            String[] keyValues = queryString.split(SPLITTER);
            for (String keyValue : keyValues) {
                if (keyValue.contains(KV_SPLITTER)) {
                    String[] temp = keyValue.split(KV_SPLITTER);
                    if (temp.length == 2) {
                        this.httpQueryParameters
                                .addQueryParameter(new HttpQueryParameter(temp[0], temp[1]));
                    }

                }
            }
        }
        return this.httpQueryParameters;
    }
}
