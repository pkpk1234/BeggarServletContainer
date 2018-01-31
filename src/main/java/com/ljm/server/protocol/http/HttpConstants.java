package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 */
public interface HttpConstants {
    String KV_SPLITTER = "=";
    String CRLF = "\r\n";
    String CONTENT_TYPE = "Content-Type";
    String CONTENT_LENGTH = "Content-Length";
    String CONTENT_ENCODING = "Content-Encoding";
    String TRANSFER_ENCODING = "Transfer-Encoding";
    String ENCODING_CHUNKED = "chunked";
    String ENCODING_IDENTITY = "identity";
}
