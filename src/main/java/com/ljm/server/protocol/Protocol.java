package com.ljm.server.protocol;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/12
 *
 * 应用协议接口
 */
public interface Protocol {
    /**
     * 返回协议名
     * @return
     */
    String getName();

    /**
     * 返回协议版本
     * @return
     */
    String version();
}
