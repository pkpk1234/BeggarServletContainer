package com.ljm.server;

import com.ljm.server.config.ServerConfig;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class BootStrap {
    public static void main(String[] args) throws IOException {
        ServerConfig serverConfig = new ServerConfig();
        Server server = ServerFactory.getServer(serverConfig);
        server.start();
    }
}
