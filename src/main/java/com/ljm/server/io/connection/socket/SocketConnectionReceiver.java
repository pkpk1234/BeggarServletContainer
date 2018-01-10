package com.ljm.server.io.connection.socket;

import com.ljm.server.io.connection.ConnectionReceiver;
import com.ljm.server.io.connector.ConnectorException;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketConnectionReceiver implements ConnectionReceiver {
    public SocketConnectionReceiver(Socket socket) {
        this.socket = socket;
    }

    private final Socket socket;

    @Override
    public InputStream getInputStream() {
        try {
            return socket.getInputStream();
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
    }

    @Override
    public SocketChannel getInputSocketChannel() {
        throw new ConnectorException("not support NIO");
    }
}
