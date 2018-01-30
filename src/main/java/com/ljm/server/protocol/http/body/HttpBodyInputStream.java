package com.ljm.server.protocol.http.body;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/30
 */
public class HttpBodyInputStream extends InputStream {
    private static final int CHAR_LEN = 3;
    private final InputStream inputStream;
    private long contentLength;
    private boolean isChuncked;
    private long readed = 0;
    private char[] chars = new char[CHAR_LEN];

    public HttpBodyInputStream(InputStream inputStream, boolean ifChuncked) {
        this.inputStream = inputStream;
        this.isChuncked = ifChuncked;
    }

    @Override
    public int read() throws IOException {
        readed++;
        if (isChuncked) {
            if (readed % CHAR_LEN == 1) {
                if (new String(chars).equals("\n\r\n")) {
                    return -1;
                }

            }
            int i = this.inputStream.read();
            chars[(int) (readed - 1) % CHAR_LEN] = (char) i;
            return i;

        } else {
            if (readed > contentLength) {
                return -1;
            } else {
                return this.inputStream.read();
            }
        }
    }
}
