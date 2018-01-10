package com.ljm.server.io.connection.channel;

import com.ljm.server.io.connection.Connection;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketChannelConnection implements Connection {

    private final SocketChannel socketChannel;

    public SocketChannelConnection(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

}
