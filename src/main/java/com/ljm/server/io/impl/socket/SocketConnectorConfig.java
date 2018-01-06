package com.ljm.server.io.impl.socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketConnectorConfig {
    private final int port;

    public SocketConnectorConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
