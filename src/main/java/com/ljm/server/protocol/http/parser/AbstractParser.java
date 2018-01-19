package com.ljm.server.protocol.http.parser;

/**
 * @author 李佳明 https://github.com/pkpk1234
 */
public abstract class AbstractParser {
    protected final String KV_SPLITTER = "=";
    protected final String CRLF = "\r\n";
    protected final String CONTENT_TYPE="Content-Type";
}
