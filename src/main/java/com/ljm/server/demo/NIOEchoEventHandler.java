package com.ljm.server.demo;

import com.ljm.server.event.handler.AbstractEventHandler;
import com.ljm.server.event.handler.HandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class NIOEchoEventHandler extends AbstractEventHandler<SelectionKey> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NIOEchoEventHandler.class);

    @Override
    protected void doHandle(SelectionKey key) {
        try {
            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                socketChannel.read(byteBuffer);

            } else if (key.isWritable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer output = (ByteBuffer) key.attachment();
                output.flip();
                socketChannel.write(output);
                output.compact();
            }
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

}
