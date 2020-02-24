package by.schepov.exception;

public class ExpressionCalculatorException extends Exception {
    public ExpressionCalculatorException() {
    }

    public ExpressionCalculatorException(String message) {
        super(message);
    }

    public ExpressionCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionCalculatorException(Throwable cause) {
        super(cause);
    }
}
