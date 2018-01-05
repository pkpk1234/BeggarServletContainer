package com.ljm.server;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 * server接口
 */
public interface Server {
    /**
     * 启动服务器
     */
    void start() throws IOException;

    /**
     * 关闭服务器
     */
    void stop();

    ServerStatus getStatus();

    int getPort();
}
