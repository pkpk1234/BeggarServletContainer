package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpRequestParameter;
import com.ljm.server.protocol.http.HttpRequestParameters;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class TestDefaultHttpRequestParameterParser {

    @Test
    public void test() {
        String queryStr = "a=123&a1=1&b=456&a=321";
        DefaultHttpRequestParameterParser httpRequestParameterParser
                = new DefaultHttpRequestParameterParser();
        HttpRequestParameters result = httpRequestParameterParser.parse(queryStr);
        List<HttpRequestParameter> parameters = result.getPrameter("a");
        assertNotNull(parameters);
        assertEquals(2, parameters.size());
        assertEquals("123", parameters.get(0).getValue());
        assertEquals("321", parameters.get(1).getValue());
    }
}
