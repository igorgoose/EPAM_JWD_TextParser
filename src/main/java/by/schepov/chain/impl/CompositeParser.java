package by.schepov.chain.impl;

import by.schepov.composite.TextComponent;
import by.schepov.composite.impl.TextComposite;
import by.schepov.composite.impl.TextCompositeType;
import by.schepov.exception.ParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompositeParser extends TextUnitParser {

    protected TextCompositeType type;

    public CompositeParser(TextCompositeType type) {
        this.type = type;
    }

    public void setType(TextCompositeType type) {
        this.type = type;
    }

    @Override
    public TextComponent parse(String toParse) throws ParserException {
        if (nextParser == null) {
            throw new ParserException();
        }
        TextComposite textComposite = new TextComposite(this.type);
        Pattern pattern = Pattern.compile(this.type.getRegex());
        Matcher matcher = pattern.matcher(toParse);
        while (matcher.find()) {
            textComposite.add(nextParser.parse(matcher.group()));
        }
        return textComposite;
    }


}
