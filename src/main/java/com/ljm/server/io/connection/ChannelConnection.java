package com.ljm.server.io.connection;


import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 底层为Channel的Connection
 * @author 李佳明 https://github.com/pkpk1234
 */
public interface ChannelConnection extends Connection {
    /**
     * 读取数据
     *
     * @param byteBuffer
     * @return
     * @throws IOException
     */
    byte[] read(ByteBuffer byteBuffer) throws IOException;
}
