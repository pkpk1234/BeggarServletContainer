package com.ljm.server;

import com.ljm.server.io.connector.Connector;

import java.io.IOException;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 * server接口
 */
public interface Server {
    /**
     * 启动服务器
     * @throws IOException
     */
    void start() throws IOException;

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 获取服务器启停状态
     * @return
     */
    ServerStatus getStatus();

    /**
     * 获取服务器管理的Connector列表
     * @return
     */
    Set<Connector> getConnectors();
}
