package com.ljm.server.protocol.http;

import com.ljm.server.protocol.http.body.HttpBody;
import com.ljm.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/12
 * <p>
 * HTTP消息
 * 参考 https://tools.ietf.org/html/rfc2616#page-31
 * <p>
 * generic-message = start-line
 * *(message-header CRLF)
 * CRLF
 * [ message-body ]
 * <p>
 * <p>
 * start-line      = Request-Line | Status-Line
 */
public interface HttpMessage {
    /**
     * 获取起始行
     *
     * @return
     */
    StartLine getStartLine();

    /**
     * 获取HTTP头集合
     *
     * @return
     */
    IMessageHeaders getMessageHeaders();

    /**
     * 获取HTTP Body
     *
     * @return
     */
    Optional<HttpBody> getHttpBody();
}
