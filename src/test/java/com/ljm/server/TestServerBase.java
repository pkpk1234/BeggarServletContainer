package com.ljm.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public abstract class TestServerBase {
    private static Logger logger = LoggerFactory.getLogger(TestServerBase.class);

    /**
     * 在单独的线程中启动Server，如果启动不成功，抛出异常
     *
     * @param server
     */
    protected void startServer(Server server) {
        //在另外一个线程中启动server
        new Thread(() -> {
            try {
                server.start();
            } catch (IOException e) {
                //转为RuntimeException抛出，避免异常丢失
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * 等待Server启动
     *
     * @param server
     */
    protected void waitServerStart(Server server) {
        //如果server未启动，就sleep一下
        while (server.getStatus().equals(ServerStatus.STOPED)) {
            logger.info("等待server启动");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
