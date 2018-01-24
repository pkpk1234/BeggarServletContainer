package com.ljm.server.io.connector.impl.socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketConnectorConfig {
    private final int port;
    private final String host;
    private final int backLog;

    public SocketConnectorConfig(int port, String host, int backLog) {
        this.port = port;
        this.host = host;
        this.backLog = backLog;
    }

    public int getBackLog() {
        return backLog;
    }

    public SocketConnectorConfig(int port, String host) {
        this(port, host, 64);
    }

    public SocketConnectorConfig(int port) {
        this(port, null);
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
