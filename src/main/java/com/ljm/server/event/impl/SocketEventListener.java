package com.ljm.server.event.impl;

import com.ljm.server.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/7
 */
public class SocketEventListener implements EventListener<Socket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEventListener.class);

    @Override
    public void onEvent(Socket socket) {
        LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
    }
}
