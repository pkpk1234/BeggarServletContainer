package com.ljm.server.io.connection.socket;

import com.ljm.server.io.connection.ConnectionReader;
import com.ljm.server.io.connector.ConnectorException;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketConnectionReader implements ConnectionReader {
    public SocketConnectionReader(Socket socket) {
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
}
