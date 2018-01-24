package com.ljm.server.io.connector;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public interface ConnectorFactory {
    /**
     * 返回Connector
     * @return
     */
    AbstractConnector getConnector();
}
