package com.ljm.server.io.connection.socket;

import com.ljm.server.io.connection.ConnectionWriter;
import com.ljm.server.io.connector.ConnectorException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/10
 */
public class SocketConnectionWriter implements ConnectionWriter {
    private final Socket socket;

    public SocketConnectionWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public OutputStream getOutputStream() {
        try {
            return socket.getOutputStream();
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
    }
}
