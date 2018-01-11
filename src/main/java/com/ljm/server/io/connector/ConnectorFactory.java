package com.ljm.server.io.connector;

import com.ljm.server.io.connector.AbstractConnector;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public interface ConnectorFactory {
    AbstractConnector getConnector();
}
