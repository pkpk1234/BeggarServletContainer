package com.ljm.server.io.connection.socket;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSocketConnection {


    @Test
    public void testRead() throws IOException {
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("Hello world".getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream(64));

        SocketConnection socketConnection = new SocketConnection(socket);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(64);
        byte[] bytes = new byte[64];
        int readLength = -1;
        while ((readLength = socketConnection.read(bytes, 0, bytes.length)) != -1) {
            outputStream.write(bytes, 0, readLength);
        }
        assertEquals("Hello world", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWrite() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        SocketConnection socketConnection = new SocketConnection(socket);
        String input = "Hello world";
        socketConnection.write(input.getBytes());
        assertEquals(input, byteArrayOutputStream.toString("UTF-8"));
    }
}
