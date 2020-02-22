package by.schepov.util;

public enum Operation {
    TILDE(0),
    MULTIPLICATION(1),
    DIVISION(1),
    PLUS(2),
    MINUS(2),
    SHIFT_RIGHT(3),
    SHIFT_LEFT(3),
    BITWISE_AND(4),
    XOR(5),
    BITWISE_OR(6),
    LEFT_BRACKET(7),
    RIGHT_BRACKET(7);

    private int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
