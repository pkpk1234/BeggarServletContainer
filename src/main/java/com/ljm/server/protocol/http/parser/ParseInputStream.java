package com.ljm.server.protocol.http.parser;

import java.io.IOException;
import java.io.InputStream;

public class ParseInputStream extends InputStream {
    private final InputStream inputStream;
    private int readCount = -1;

    public ParseInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        readCount++;
        return this.inputStream.read();
    }

    public int getReadCount() {
        return readCount;
    }
}
