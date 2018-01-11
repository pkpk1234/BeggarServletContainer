package com.ljm.server.io.connection;


import java.io.IOException;
import java.nio.ByteBuffer;

public interface ChannelConnection extends Connection {
    byte[] read(ByteBuffer byteBuffer) throws IOException;
}
