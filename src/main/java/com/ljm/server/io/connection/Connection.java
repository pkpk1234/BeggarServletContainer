package com.ljm.server.io.connection;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public interface Connection {
    /**
     * 写入byte[]数组中的所有数据
     *
     * @param bytes
     * @throws IOException
     */
    void write(byte[] bytes) throws IOException;

    /**
     * 写入byte[]数组中[offset,length-1]的数据
     *
     * @param bytes
     * @param offset
     * @param length
     * @throws IOException
     */
    void write(byte[] bytes, int offset, int length) throws IOException;

    /**
     * 读取数据填满byte[]数组
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    int read(byte[] bytes) throws IOException;

    /**
     * 读取数据写入byte[offset,length-1]
     *
     * @param bytes
     * @param offset
     * @param length
     * @return
     * @throws IOException
     */
    int read(byte[] bytes, int offset, int length) throws IOException;
}
