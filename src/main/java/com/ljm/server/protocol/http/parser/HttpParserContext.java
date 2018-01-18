package com.ljm.server.protocol.http.parser;

/**
 * HTTP Message解析上下文
 * @author 李佳明 https://github.com/pkpk1234
 */
public class HttpParserContext {

    protected byte[] httpMessageBytes;
    protected String requestQueryString;
    protected boolean hasBody;
    protected int bytesLengthBeforeBody;
    
    public byte[] getHttpMessageBytes() {
        return httpMessageBytes;
    }

    public void setHttpMessageBytes(byte[] httpMessageBytes) {
        this.httpMessageBytes = httpMessageBytes;
    }

    public String getRequestQueryString() {
        return requestQueryString;
    }

    public void setRequestQueryString(String requestQueryString) {
        this.requestQueryString = requestQueryString;
    }

    public boolean getHasBody() {
        return hasBody;
    }

    public void setHasBody(boolean hasBody) {
        this.hasBody = hasBody;
    }

    public int getBytesLengthBeforeBody() {
        return bytesLengthBeforeBody;
    }

    public void setBytesLengthBeforeBody(int bytesLengthBeforeBody) {
        this.bytesLengthBeforeBody = bytesLengthBeforeBody;
    }
}
