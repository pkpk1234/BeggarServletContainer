package com.ljm.server.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class IoUtils {

    private static Logger logger = LoggerFactory.getLogger(IoUtils.class);

    /**
     * 安静地关闭，不抛出异常
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if(closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
    }
}
