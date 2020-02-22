package by.schepov.chain;

import by.schepov.composite.TextComponent;
import by.schepov.exception.ParserException;

public interface Parser {
    void setNext(Parser parser);
    TextComponent parse(String toParse) throws ParserException;
}
