package com.ljm.server.io.connection.socket;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestSocketConnection {
    private static Socket socket;

    @BeforeClass
    public static void init() throws IOException {
        socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("Hello world".getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream(64));
    }

    @Test
    public void testRead() throws IOException {
        SocketConnection socketConnection = new SocketConnection(socket);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(64);
        byte[] bytes = new byte[64];
        int readLength = -1;
        while ((readLength = socketConnection.read(bytes, 0, bytes.length)) != -1) {
            outputStream.write(bytes, 0, readLength);
        }
        assertEquals("Hello world", outputStream.toString("UTF-8"));
    }
}
