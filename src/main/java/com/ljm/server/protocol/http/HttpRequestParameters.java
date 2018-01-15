package com.ljm.server.protocol.http;

import com.google.common.collect.LinkedListMultimap;

import java.util.List;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/15
 */
public class HttpRequestParameters {

    private final LinkedListMultimap<String, HttpRequestParameter> prametersMultiMap;

    public HttpRequestParameters() {
        this.prametersMultiMap = LinkedListMultimap.create();
    }


    public List<HttpRequestParameter> getPrameter(String name) {
        return this.prametersMultiMap.get(name);
    }

    public List<HttpRequestParameter> getRequestParameters() {
        return this.prametersMultiMap.values();
    }

    public void addRequestParameter(HttpRequestParameter httpRequestParameter) {
        this.prametersMultiMap.put(httpRequestParameter.getName(), httpRequestParameter);
    }

    public void removeRequestParameter(HttpRequestParameter httpRequestParameter) {
        this.prametersMultiMap.remove(httpRequestParameter.getName(), httpRequestParameter);
    }

    public void removeRequestParameters(String httpRequestParameter) {
        this.prametersMultiMap.removeAll(httpRequestParameter);
    }

    public boolean hasRequestParameter(String httpRequestParameter) {
        return this.prametersMultiMap.containsKey(httpRequestParameter);
    }

    public Set<String> getRequestParameterNames() {
        return this.prametersMultiMap.keySet();
    }
}
