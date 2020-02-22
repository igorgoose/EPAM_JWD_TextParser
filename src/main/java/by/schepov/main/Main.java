package by.schepov.main;

import by.schepov.parser.Parser;
import by.schepov.parser.impl.CharacterParser;
import by.schepov.parser.impl.CompositeParser;
import by.schepov.composite.TextComponent;
import by.schepov.composite.impl.TextCompositeType;
import by.schepov.exception.ParserException;
import by.schepov.exception.ParserInitializationException;

public class Main {
    private static Parser createParser() throws ParserInitializationException {
        Parser parser = null, nextParser, parserToReturn = null;
        for (TextCompositeType type :
                TextCompositeType.values()) {
            nextParser = new CompositeParser(type);
            if (parser != null) {
                parser.setNext(nextParser);
            } else {
                parserToReturn = nextParser;
            }
            parser = nextParser;
        }
        if (parser == null) {
            throw new ParserInitializationException();
        }
        parser.setNext(new CharacterParser());
        return parserToReturn;
    }

    public static void main(String[] args) {
        String regex = TextCompositeType.TEXT.getRegex();
        String initialText = "\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic type setting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(6^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
                "\tIt is a (4^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.\n" +
                "\tBye.\n";
        System.out.println(initialText);
        try {
            Parser textParser = createParser();
            TextComponent textComponent = textParser.parse(initialText);
            System.out.println("_________________________________________________");
            System.out.println(textComponent.toString());
        } catch (ParserInitializationException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        }

    }
}
