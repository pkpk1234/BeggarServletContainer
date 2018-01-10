package com.ljm.server.io.connector;

import com.ljm.server.LifeCycle;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/9
 */
public interface Connector extends LifeCycle {
    /**
     * 获取监听的端口
     *
     * @return
     */
    int getPort();

    /**
     * 获取监听的IP、主机名
     *
     * @return
     */
    String getHost();
}
