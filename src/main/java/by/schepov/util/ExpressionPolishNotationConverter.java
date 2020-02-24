package by.schepov.util;

import by.schepov.exception.InvalidBracketsPositionException;
import by.schepov.exception.PolishNotationConverterException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExpressionPolishNotationConverter {

    private String expression;

    public ExpressionPolishNotationConverter() {

    }

    public ExpressionPolishNotationConverter(String expression) {
        this.expression = expression;
    }


    public void setExpression(String newExpression) {
        this.expression = newExpression;
    }

    public List<String> getPolishNotation() throws PolishNotationConverterException {
        if(expression == null){
            throw new PolishNotationConverterException("Expression is not set");
        }
        Deque<Operator> stack = new ArrayDeque<>();
        List<String> polishNotationList = new LinkedList<>();
        int currentIndex = 0;
        int expressionLength = expression.length();
        while (currentIndex < expressionLength) {
            if (Character.isDigit(expression.charAt(currentIndex))) {
                int newIndex = findLastDigitIndex(currentIndex);
                String number = expression.substring(currentIndex, newIndex);
                polishNotationList.add(number);
                currentIndex = newIndex;
                continue;
            }
            Operator operator = Operator.getOperator(expression.charAt(currentIndex));
            ++currentIndex;
            Operator stackItem;
            switch (operator) {
                case OPEN_BRACKET:
                    stack.push(operator);
                    break;
                case CLOSE_BRACKET:
                    if (stack.isEmpty()) {
                        throw new PolishNotationConverterException("Invalid bracket structure");
                    }
                    stackItem = stack.pop();
                    while (stackItem != Operator.OPEN_BRACKET) {
                        if(stack.isEmpty()){
                            throw new PolishNotationConverterException("Incorrect bracket structure");
                        }
                        polishNotationList.add(stackItem.toString());
                        stackItem = stack.pop();
                    }
                    break;
                default:
                    if (operator == Operator.SHIFT_LEFT || operator == Operator.SHIFT_RIGHT) {
                        ++currentIndex;
                    }
                    if (!stack.isEmpty()) {
                        stackItem = stack.peekFirst();
                        if (stackItem.getPriority() <= operator.getPriority()) {
                            stack.pop();
                            polishNotationList.add(stackItem.toString());
                        }
                    }
                    stack.push(operator);
                    break;

            }
        }
        while(!stack.isEmpty()){
            polishNotationList.add(stack.pop().toString());
        }
        return polishNotationList;
    }

    private int findLastDigitIndex(int currentIndex) {
        int length = expression.length();
        while (currentIndex < length &&
                (Character.isDigit(expression.charAt(currentIndex))
                        || expression.charAt(currentIndex) == '.')) {
            ++currentIndex;
        }
        return currentIndex;
    }
}
