package by.schepov.util;

import by.schepov.exception.InvalidOperatorCharacterException;
import by.schepov.exception.OperatorException;

public enum Operator {
    TILDE('~', 0),
    MULTIPLICATION('*', 1),
    DIVISION('/', 1),
    PLUS('+', 2),
    MINUS('-', 2),
    SHIFT_RIGHT('>', 3, ">>"),
    SHIFT_LEFT('<', 3, "<<"),
    BITWISE_AND('&', 4),
    XOR('^', 5),
    BITWISE_OR('|', 6),
    OPEN_BRACKET('(', 7),
    CLOSE_BRACKET(')', 7);

    private char operatorCharacter;
    private int priority;
    private String value;

    Operator(char operatorCharacter, int priority, String value) {
        this.operatorCharacter = operatorCharacter;
        this.priority = priority;
        this.value = value;
    }

    Operator(char operatorCharacter, int priority) {
        this.operatorCharacter = operatorCharacter;
        this.priority = priority;
        value = String.valueOf(operatorCharacter);
    }

    public int getPriority() {
        return priority;
    }

    public char getOperatorCharacter() {
        return operatorCharacter;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Operator getOperator(char operatorCharacter) throws InvalidOperatorCharacterException {
        switch (operatorCharacter) {
            case '~':
                return TILDE;
            case '*':
                return MULTIPLICATION;
            case '/':
                return DIVISION;
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '>':
                return SHIFT_RIGHT;
            case '<':
                return SHIFT_LEFT;
            case '&':
                return BITWISE_AND;
            case '^':
                return XOR;
            case '|':
                return BITWISE_OR;
            case '(':
                return OPEN_BRACKET;
            case ')':
                return CLOSE_BRACKET;
        }
        throw new InvalidOperatorCharacterException("Invalid operator character representation");
    }

    public static int performOperation(String operator, int operandLeft, int operandRight) throws OperatorException {
        switch (operator) {
            case "~":
                return ~operandLeft;
            case "*":
                return operandLeft * operandRight;
            case "/":
                return operandLeft / operandRight;
            case "+":
                return operandLeft + operandRight;
            case "-":
                return operandLeft - operandRight;
            case "<<":
                return operandLeft << operandRight;
            case ">>":
                return operandLeft >> operandRight;
            case "&":
                return operandLeft & operandRight;
            case "^":
                return operandLeft ^ operandRight;
            case "|":
                return operandLeft | operandRight;
            default:
                throw new OperatorException("Invalid operator: " + operator);
        }
    }
}
