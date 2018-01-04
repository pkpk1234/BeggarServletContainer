package com.ljm.server.impl;

import com.ljm.server.Server;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class SimpleServer implements Server {
    @Override
    public void start() {
        System.out.println("Server start");
    }

    @Override
    public void stop() {
        System.out.println("Server stop");
    }
}
