package com.ljm.server.io.connection.channel;

import com.ljm.server.io.connection.ConnectionReceiver;
import com.ljm.server.io.connector.ConnectorException;

import java.io.InputStream;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketChannelConnectionReceiver implements ConnectionReceiver {
    private final SocketChannel socketChannel;

    public SocketChannelConnectionReceiver(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public InputStream getInputStream() {
        throw new ConnectorException("not support BIO");
    }

    @Override
    public SocketChannel getInputSocketChannel() {
        return socketChannel;
    }
}
