package com.ljm.server.io.connection.channel;

import com.ljm.server.io.connection.ConnectionWriter;
import com.ljm.server.io.connector.ConnectorException;

import java.io.OutputStream;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/11
 */
public class SocketChannelConnectionWriter implements ConnectionWriter {

    public SocketChannelConnectionWriter(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    private final SocketChannel socketChannel;

    @Override
    public OutputStream getOutputStream() {
        throw new ConnectorException("not support for BIO.");
    }

    @Override
    public SocketChannel getOutputSocketChannel() {
        return this.socketChannel;
    }
}
