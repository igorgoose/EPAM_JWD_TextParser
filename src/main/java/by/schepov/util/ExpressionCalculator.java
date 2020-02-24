package by.schepov.util;

import by.schepov.exception.ExpressionCalculatorException;
import by.schepov.exception.OperatorException;
import by.schepov.parser.impl.ExpressionParser;

import java.util.*;
import java.util.regex.Pattern;

public class ExpressionCalculator {

    private static final Pattern NUMBER_REGEX = Pattern.compile(ExpressionParser.getNumberRegex());

    private ExpressionCalculator() {

    }

    public static int calculate(List<String> polishNotation) throws ExpressionCalculatorException {
        if (polishNotation == null) {
            throw new ExpressionCalculatorException();
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int operandLeft, operandRight;
        try {
            for (String item : polishNotation) {
                if (NUMBER_REGEX.matcher(item).matches()) {
                    stack.push(Integer.parseInt(item));
                    continue;
                }
                checkNotEmptyStack(stack);
                operandRight = stack.pop();
                if (item.equals("~")) {
                    stack.push(Operator.performOperation(item, operandRight, 0));
                    continue;
                }
                checkNotEmptyStack(stack);
                operandLeft = stack.pop();
                stack.push(Operator.performOperation(item, operandLeft, operandRight));
            }
            checkNotEmptyStack(stack);
            return stack.pop();
        } catch (OperatorException e) {
            throw new ExpressionCalculatorException("Invalid operator", e);
        }
    }

    private static void checkNotEmptyStack(Deque<Integer> stack) throws ExpressionCalculatorException {
        if(stack.isEmpty()){
            throw new ExpressionCalculatorException("Invalid expression passed!");
        }
    }

}
