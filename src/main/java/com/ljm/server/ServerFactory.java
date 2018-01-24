package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.impl.SimpleServer;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class ServerFactory {
    /**
     * 返回Server实例
     *
     * @return
     */
    public static Server getServer(ServerConfig serverConfig) {
        return new SimpleServer(serverConfig.getConnectors());
    }
}
