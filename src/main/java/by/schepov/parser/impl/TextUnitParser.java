package by.schepov.parser.impl;

import by.schepov.parser.Parser;
import by.schepov.composite.TextComponent;
import by.schepov.exception.ParserException;


public abstract class TextUnitParser implements Parser {
    protected Parser nextParser;


    public void setNext(Parser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public abstract TextComponent parse(String toParse) throws ParserException;
}
