package com.ljm.server.protocol.http.parser;


public abstract class AbstractColleague {
    protected AbstractParserContext abstractParserContext;

    public AbstractColleague(AbstractParserContext abstractParserContext) {
        this.abstractParserContext = abstractParserContext;
    }
}
