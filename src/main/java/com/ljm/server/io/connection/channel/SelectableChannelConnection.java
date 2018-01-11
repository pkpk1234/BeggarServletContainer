package com.ljm.server.io.connection.channel;

import com.ljm.server.io.connection.Connection;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SelectableChannelConnection implements Connection {

    private final SelectionKey selectionKey;

    public SelectableChannelConnection(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }


    @Override
    public void write(byte[] bytes) throws IOException {
        this.write(bytes, 0, bytes.length);
    }

    @Override
    public void write(byte[] bytes, int offset, int length) throws IOException {
        if (selectionKey.isWritable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer output = ByteBuffer.wrap(bytes, 0, bytes.length);
            output.flip();
            while (output.hasRemaining()) {
                socketChannel.write(output);
            }
        }
    }

    @Override
    public int read(byte[] bytes) throws IOException {

    }

    @Override
    public int read(byte[] bytes, int start, int end) {
        if (selectionKey.isReadable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            ByteBuffer output = 

            client.read(output., 0, bytes.length);
        }
    }
}
