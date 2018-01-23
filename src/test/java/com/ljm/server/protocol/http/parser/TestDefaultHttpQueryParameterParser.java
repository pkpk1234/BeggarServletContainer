package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpQueryParameter;
import com.ljm.server.protocol.http.HttpQueryParameters;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class TestDefaultHttpQueryParameterParser {

    @Test
    public void test() {
        String queryStr = "a=123&a1=1&b=456&a=321";
        HttpParserContext.setRequestQueryString(queryStr);
        DefaultHttpQueryParameterParser httpRequestParameterParser
                = new DefaultHttpQueryParameterParser();
        HttpQueryParameters result = httpRequestParameterParser.parse();
        List<HttpQueryParameter> parameters = result.getQueryParameter("a");
        assertNotNull(parameters);
        assertEquals(2, parameters.size());
        assertEquals("123", parameters.get(0).getValue());
        assertEquals("321", parameters.get(1).getValue());
    }
}
