package com.ljm.server.protocol.http.parser;


public abstract class AbstractParser {
    protected AbstractParserContext abstractParserContext;
    protected final String CRLF = "\r\n";

    public AbstractParser(AbstractParserContext abstractParserContext) {
        this.abstractParserContext = abstractParserContext;
    }
}
