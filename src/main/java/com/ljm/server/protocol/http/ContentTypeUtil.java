package com.ljm.server.protocol.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Content Type工具类
 *
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018/1/24
 */
public class ContentTypeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentTypeUtil.class);
    private static Properties properties;

    private ContentTypeUtil() {
    }

    static {
        properties
                = new Properties();
        try {
            properties.load(ContentTypeUtil.class
                    .getClassLoader().getResourceAsStream("mime-mapping.properties"));
        } catch (IOException e) {
            LOGGER.error("load mime-mapping.properties failed", e);
        }
    }

    /**
     * 通过文件后缀获取到Content-Type
     *
     * @param filePrefix
     * @return
     */
    public static String getCotentType(String filePrefix) {
        return properties.getProperty(filePrefix, "application/octet-stream");
    }

}
