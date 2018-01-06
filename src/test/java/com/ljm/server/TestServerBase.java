package com.ljm.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/6
 */
public abstract class TestServerBase {
    private static Logger logger = LoggerFactory.getLogger(TestServerBase.class);

    /**
     * 等待Server启动
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
