package com.ljm.server.io.connection.socket;

import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connection.ConnectionReader;
import com.ljm.server.io.connection.ConnectionWriter;

import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketConnection implements Connection {
    private final Socket socket;

    public SocketConnection(Socket socket) {
        this.socket = socket;
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
    public ConnectionReader getConnectionRead() {
        return new SocketConnectionReader(socket);
    }

    @Override
    public ConnectionWriter getConnectionWriter() {
        return new SocketConnectionWriter(socket);
    }
}
