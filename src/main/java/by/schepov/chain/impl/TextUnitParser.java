package by.schepov.chain.impl;

import by.schepov.chain.Parser;
import by.schepov.composite.TextComponent;
import by.schepov.exception.ParserException;


public abstract class TextUnitParser implements Parser{
    protected Parser nextParser;


    public void setNext(Parser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public abstract TextComponent parse(String toParse) throws ParserException;
}
