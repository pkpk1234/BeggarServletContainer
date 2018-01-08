package com.ljm.server.handler.impl;

import com.ljm.server.handler.AbstractEventHandler;
import com.ljm.server.handler.HandlerException;
import com.ljm.server.io.IoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/8
 */
public class FileEventHandler extends AbstractEventHandler<Socket> {

    private final String docBase;

    public FileEventHandler(String docBase) {
        this.docBase = docBase;
    }

    @Override
    protected void doHandle(Socket socket) {
        getFile(socket);
    }

    private void getFile(Socket socket) {
        InputStream inputstream = null;
        OutputStream outputStream = null;
        try {
            inputstream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(inputstream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.append("Server connected.Welcome to File Server.\n");
            printWriter.flush();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("stop")) {
                    printWriter.append("bye bye.\n");
                    printWriter.flush();
                    break;
                } else {
                    Path filePath = Paths.get(this.docBase, line);
                    if (Files.isDirectory(filePath)) {
                        Files.list(filePath).forEach(fileName->{
                            printWriter.append(fileName.getFileName().toString())
                                    .append("\n").flush();
                        });
                    } else if (Files.isReadable(filePath)) {
                        Files.copy(filePath, outputStream);
                    } else {
                        printWriter.append("File ").append(filePath.toString())
                                .append(" is not found.").append("\n").flush();
                    }

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
