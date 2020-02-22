package by.schepov.parser.impl;

import by.schepov.composite.TextComponent;
import by.schepov.exception.ParserException;

public class ExpressionParser extends TextUnitParser {

    private final static String NUMBER_REGEX = "((\\d+)(\\.\\d+)?)";
    private final static String PRENUMBER_REGEX = "((~)*(\\()*(~)*(\\()*)";
    private final static String POSTNUMBER_REGEX = "(\\)*)";
    private final static String OPERATION_REGEX = "([+-*/^&|(>>)(<<)])";
    public static final String EXPRESSION_REGEX =
            PRENUMBER_REGEX + "?" + NUMBER_REGEX + POSTNUMBER_REGEX + "?"
                    + "(" + OPERATION_REGEX + PRENUMBER_REGEX + "?" +
                    NUMBER_REGEX + POSTNUMBER_REGEX + "?" + ")+";

    @Override
    public TextComponent parse(String toParse) throws ParserException {
        return null;
    }

    public static String getNumberRegex() {
        return NUMBER_REGEX;
    }

    public static String getPrenumberRegex() {
        return PRENUMBER_REGEX;
    }

    public static String getPostnumberRegex() {
        return POSTNUMBER_REGEX;
    }

    public static String getOperationRegex() {
        return OPERATION_REGEX;
    }
}
