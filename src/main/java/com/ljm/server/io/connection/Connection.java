package com.ljm.server.io.connection;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public interface Connection {
    boolean isOpen();
    boolean isWritable();
    boolean isReadable();
    void close();
    ConnectionReader getConnectionRead();
    ConnectionWriter getConnectionWriter();

}
