package com.ljm.server.io.event.handler.impl;

import com.ljm.server.event.handler.AbstractEventHandler;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.utils.IoUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class EchoEventHandler extends AbstractEventHandler<Connection> {

    @Override
    protected void doHandle(Connection connection) {
        echo(connection.getInputStream(), connection.getOutputStream());
    }

    protected void echo(InputStream inputstream, OutputStream outputStream) {
        try {
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
        } finally {
            IoUtils.closeQuietly(inputstream);
            IoUtils.closeQuietly(outputStream);
        }
    }

}
