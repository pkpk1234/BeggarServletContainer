package com.ljm.server.io;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/9
 */
public interface Connector {
    /**
     * 获取监听的端口
     * @return
     */
    int getPort();

    /**
     * 获取监听的IP、主机名
     * @return
     */
    String getHost();
}
