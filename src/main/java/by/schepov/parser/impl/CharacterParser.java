package by.schepov.parser.impl;

import by.schepov.composite.TextComponent;
import by.schepov.composite.impl.Character;
import by.schepov.exception.ParserException;


public class CharacterParser extends TextUnitParser {

    public CharacterParser() {
    }

    @Override
    public TextComponent parse(String toParse) throws ParserException {
        if (toParse == null) {
            throw new ParserException("null");
        }
        if (toParse.length() == 0) {
            throw new ParserException("invalid: empty expression");
        }
        return new Character(toParse.charAt(0));
    }
}
