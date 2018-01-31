package com.ljm.server.protocol.http.parser;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018/1/21
 */
public class BodyInfo {
    private String contentType;
    //Content-Type中的Charset：如UTF-8，GB2312等
    private String charset;
    //Content-Encoding:压缩格式，如gzip、deflate等
    private String encoding;
    private boolean hasBody;
    private long contentLength;
    private String transferEncoding;

    public BodyInfo() {
    }

    public BodyInfo(String contentType, String encoding, boolean hasBody, int contentLength) {
        this.contentType = contentType;
        this.charset = encoding;
        this.hasBody = hasBody;
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public boolean isHasBody() {
        return hasBody;
    }

    public void setHasBody(boolean hasBody) {
        this.hasBody = hasBody;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTransferEncoding() {
        return transferEncoding;
    }

    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
    }
}
