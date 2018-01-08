package com.ljm.server.handler.impl;

import com.ljm.server.handler.AbstractEventHandler;
import com.ljm.server.handler.HandlerException;
import com.ljm.server.io.IoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class EchoEventHandler extends AbstractEventHandler<Socket> {

    @Override
    protected void doHandle(Socket socket) {
        InputStream inputstream = null;
        OutputStream outputStream = null;
        try {
            inputstream = socket.getInputStream();
            outputStream = socket.getOutputStream();
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
        } catch (IOException e) {
            throw new HandlerException(e);
        } finally {
            IoUtils.closeQuietly(inputstream);
            IoUtils.closeQuietly(outputStream);
        }
    }

}
