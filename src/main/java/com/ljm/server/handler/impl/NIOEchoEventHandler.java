package com.ljm.server.handler.impl;

import com.ljm.server.handler.AbstractEventHandler;
import com.ljm.server.handler.HandlerException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class NIOEchoEventHandler extends AbstractEventHandler<SelectionKey> {
    @Override
    protected void doHandle(SelectionKey key) {
        try {
            if (key.isReadable()) {
                SocketChannel client = (SocketChannel) key.channel();
                ByteBuffer output = (ByteBuffer) key.attachment();
                client.read(output);
            } else if (key.isWritable()) {
                SocketChannel client = (SocketChannel) key.channel();
                ByteBuffer output = (ByteBuffer) key.attachment();
                output.flip();
                client.write(output);
                output.compact();
            }
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }
}
