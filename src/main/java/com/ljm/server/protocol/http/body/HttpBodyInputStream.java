package com.ljm.server.protocol.http.body;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装Body流
 *
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/30
 */
public class HttpBodyInputStream extends InputStream {
    //chunked body使用 0\r\n\r\n结尾
    private static final char[] TAILER_CHARS = {'0', '\r', '\n', '\r', '\n'};
    private final InputStream inputStream;
    private long contentLength;
    private boolean isChuncked;
    private long readed = 0;
    private boolean isFinished = false;
    private int idx = 0;

    public HttpBodyInputStream(InputStream inputStream, boolean ifChuncked) {
        this.inputStream = inputStream;
        this.isChuncked = ifChuncked;
    }

    @Override
    public int read() throws IOException {
        if (isChuncked) {
            return readChunked();
        } else {
            return readByte();
        }
    }

    /**
     * 读取chunked body
     *
     * @return
     * @throws IOException
     */
    private int readChunked() throws IOException {
        if (isFinished) {
            return -1;
        }
        int i = this.inputStream.read();
        if (i == -1) {
            return i;
        } else {
            if (idx == TAILER_CHARS.length - 1) {
                isFinished = true;
            } else if (TAILER_CHARS[idx++] != (char) i) {
                idx = 0;
            }
        }
        return i;
    }

    /**
     * 读取非chunked body
     *
     * @return
     * @throws IOException
     */
    private int readByte() throws IOException {
        readed++;
        if (readed > contentLength) {
            return -1;
        } else {
            return this.inputStream.read();
        }
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
}
