package com.ljm.server.demo;

import com.ljm.server.event.handler.AbstractEventHandler;
import com.ljm.server.event.handler.HandlerException;
import com.ljm.server.io.connection.channel.ChannelHelper;
import com.ljm.server.io.utils.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class NIOEchoEventHandler extends AbstractEventHandler<SelectionKey> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NIOEchoEventHandler.class);
    private static final Charset CHARSET = Charset.forName("utf-8");
    private static final String LINE_SPLITTER = System.getProperty("line.separator");

    @Override
    protected void doHandle(SelectionKey key) {
        try {
            if (key.isWritable()) {

                ByteBuffer buffer = (ByteBuffer) key.attachment();
                SocketChannel socketChannel = (SocketChannel) key.channel();
                buffer.flip();
                String data = toString(buffer);
                if (!data.contains(LINE_SPLITTER)) {
                    return;
                }
                String outputData = data.substring(0,
                        data.indexOf(LINE_SPLITTER) + LINE_SPLITTER.length());

                ByteBuffer outputBuffer = fromString("echo:" + outputData);
                ChannelHelper.doWrite(outputBuffer, socketChannel);

                ByteBuffer temp = fromString(outputData);
                buffer.position(temp.limit());
                buffer.compact();
                if (outputData.equals("stop" + LINE_SPLITTER)) {
                    key.cancel();
                    IoUtils.closeQuietly(socketChannel);
                }
            } else if (key.isReadable()) {
                ByteBuffer buffer = (ByteBuffer) key.attachment();
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer readBuff = ByteBuffer.allocate(32);
                while (socketChannel.read(buffer) != -1) {
                    readBuff.flip();
                    buffer.limit(buffer.capacity());
                    buffer.put(readBuff);
                }

            }
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

    private String toString(ByteBuffer byteBuffer) {

        CharBuffer charBuffer = CHARSET.decode(byteBuffer);
        return charBuffer.toString();
    }

    public ByteBuffer fromString(String str) {
        return CHARSET.encode(str);
    }
}
