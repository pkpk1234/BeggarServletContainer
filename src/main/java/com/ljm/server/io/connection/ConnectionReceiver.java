package com.ljm.server.io.connection;

import java.io.InputStream;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public interface ConnectionReceiver {
    InputStream getInputStream();

    SocketChannel getInputSocketChannel();
}
