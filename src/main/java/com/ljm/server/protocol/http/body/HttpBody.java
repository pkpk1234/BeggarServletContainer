package com.ljm.server.protocol.http.body;

import com.ljm.server.protocol.http.HttpConstants;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class HttpBody {
    private String contentType;
    //压缩格式：deflate、gzip...
    private String encoding;
    private String transferEncoding;
    //编码格式：utf-8、gb2312...
    private String charSet;
    private HttpBodyInputStream inputStream;
    //Body段长度
    private long contentLength;

    public HttpBody(InputStream inputStream, String transferEncoding) {
        this.transferEncoding = transferEncoding;
        if (transferEncoding.equals(HttpConstants.ENCODING_CHUNKED)) {
            this.inputStream = new HttpBodyInputStream(inputStream, true);
        } else {
            this.inputStream = new HttpBodyInputStream(inputStream, false);
        }

    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public InputStream getInputStream() {
        return inputStream;
    }


    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.inputStream.setContentLength(contentLength);
        this.contentLength = contentLength;
    }

    public String getTransferEncoding() {
        return transferEncoding;
    }

    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
    }
}
