package by.schepov.parser.impl;

import by.schepov.exception.*;
import by.schepov.util.ExpressionCalculator;
import by.schepov.util.ExpressionPolishNotationConverter;
import org.apache.log4j.Logger;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    private static final Logger LOGGER = Logger.getLogger(ExpressionParser.class);

    private final static String NUMBER_REGEX = "((\\d+)(\\.\\d+)?)";
    private final static String PRENUMBER_REGEX = "(~*\\(*~*\\(*)";
    private final static String POSTNUMBER_REGEX = "(\\)*)";
    private final static String OPERATION_REGEX = "([+\\-*/^&|]|>>|<<)";
    public static final String EXPRESSION_REGEX =
            PRENUMBER_REGEX + "?" + NUMBER_REGEX + POSTNUMBER_REGEX + "?"
                    + "(" + OPERATION_REGEX + PRENUMBER_REGEX + "?" +
                    NUMBER_REGEX + POSTNUMBER_REGEX + "?" + ")+";

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(EXPRESSION_REGEX);

    private ExpressionParser(){

    }

    public static String parseAndReplaceMathExpressions(String toParse) throws ParserException, ExpressionParserException {
        StringBuffer sb = new StringBuffer();
        Matcher matcher = EXPRESSION_PATTERN.matcher(toParse);
        ExpressionPolishNotationConverter converter = new ExpressionPolishNotationConverter();
        while(matcher.find()){
            converter.setExpression(matcher.group());
            try {
                matcher.appendReplacement(sb, String.valueOf(ExpressionCalculator.calculate(converter.getPolishNotation())));
            } catch (ExpressionCalculatorException | PolishNotationConverterException e) {

                throw new ExpressionParserException(e);
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
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
