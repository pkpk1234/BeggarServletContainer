package com.ljm.server.protocol.http;

import com.google.common.collect.ArrayListMultimap;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class HttpRequestParameters {

    private final ArrayListMultimap<String, HttpRequestParameter> prametersMultiMap;

    public HttpRequestParameters(ArrayListMultimap<String, HttpRequestParameter>
                                         prametersMultiMap) {
        this.prametersMultiMap = prametersMultiMap;
    }


    Iterable<HttpRequestParameter> getPrameter(String name) {
        return this.prametersMultiMap.get(name);
    }

    Iterable<HttpRequestParameter> getRequestParameters() {
        return this.prametersMultiMap.values();
    }

    void addRequestParameter(HttpRequestParameter httpRequestParameter) {
        this.prametersMultiMap.put(httpRequestParameter.getName(), httpRequestParameter);
    }

    void removeRequestParameter(HttpRequestParameter httpRequestParameter) {
        this.prametersMultiMap.remove(httpRequestParameter.getName(), httpRequestParameter);
    }

    void removeRequestParameters(String httpRequestParameter) {
        this.prametersMultiMap.removeAll(httpRequestParameter);
    }

    boolean hasRequestParameter(String httpRequestParameter) {
        return this.prametersMultiMap.containsKey(httpRequestParameter);
    }

    Iterable<String> getRequestParameterNames() {
        return this.prametersMultiMap.keySet();
    }
}
