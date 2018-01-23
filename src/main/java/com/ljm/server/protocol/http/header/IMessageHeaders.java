package com.ljm.server.protocol.http.header;

import java.util.List;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public interface IMessageHeaders {

    /**
     * 获取名字为headerName的HttpHeader列表
     *
     * @param headerName
     * @return
     */
    List<HttpHeader> getHeaders(String headerName);

    /**
     * 获取第一个名字为headerName的HttpHeader
     *
     * @param headerName
     * @return
     */
    HttpHeader getFirstHeader(String headerName);

    /**
     * 获取所有的HttpHeader
     *
     * @return
     */
    List<HttpHeader> getAllHeaders();

    /**
     * 添加HttpHeader到集合中
     *
     * @param httpHeader
     */
    void addHeader(HttpHeader httpHeader);

    /**
     * 从集合中移除HttpHeader
     *
     * @param httpHeader
     */
    void removeHeader(HttpHeader httpHeader);

    /**
     * 从集合中移除名字为headerName的所有HttpHeader
     *
     * @param headerName
     */
    void removeHeaders(String headerName);

    /**
     * 判断集合中是否包含名字为headerName的HttpHeader
     *
     * @param headerName
     * @return
     */
    boolean hasHeader(String headerName);

    /**
     * 返回所有HttpHeader的名字，并去重
     *
     * @return
     */
    Set<String> getHeaderNames();

    /**
     * 将Headers集合中的键值对转换为HTTP协议中规定的字符串格式：
     * key:value CRLF
     * ...
     *
     * @return
     */
    String asString();
}
