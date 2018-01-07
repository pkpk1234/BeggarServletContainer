package com.ljm.server.event.impl;

import com.ljm.server.event.EventException;
import com.ljm.server.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketEventListener implements EventListener<Socket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEventListener.class);

    @Override
    public void onEvent(Socket socket) throws EventException {
        LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
        try {
            echo(socket);
        } catch (IOException e) {
            throw new EventException(e);
        }
    }

    private void echo(Socket socket) throws IOException {
        InputStream inputstream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(inputstream);
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.append("Server connected.Welcome to echo.\n");
        printWriter.flush();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("stop")) {
                printWriter.append("bye bye.\n");
                printWriter.flush();
                break;
            } else {
                printWriter.append(line);
                printWriter.append("\n");
                printWriter.flush();
            }
        }
    }
}
