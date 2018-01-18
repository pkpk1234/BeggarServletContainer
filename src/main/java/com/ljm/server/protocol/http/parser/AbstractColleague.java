package com.ljm.server.protocol.http.parser;


public abstract class AbstractColleague {
    protected AbstractParserContext abstractParserContext;
    protected final String CRLF="\r\n";
    public AbstractColleague(AbstractParserContext abstractParserContext) {
        this.abstractParserContext = abstractParserContext;
    }
}
