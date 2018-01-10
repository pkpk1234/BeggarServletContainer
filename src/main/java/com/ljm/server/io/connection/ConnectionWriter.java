package com.ljm.server.io.connection;

import java.io.OutputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public interface ConnectionWriter {
    OutputStream getOutputStream();
}
