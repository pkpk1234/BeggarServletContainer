package com.ljm.server.io.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public interface Connection {
    void write(byte[] bytes) throws IOException;
    void write(byte[] bytes,int offset,int length) throws IOException;
    int read(byte[] bytes) throws IOException;
    int read(byte[] bytes,int offset,int length) throws IOException;
}
