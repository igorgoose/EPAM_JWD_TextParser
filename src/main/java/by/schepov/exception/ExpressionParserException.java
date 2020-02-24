package by.schepov.exception;

public class ExpressionParserException extends Exception {
    public ExpressionParserException() {
    }

    public ExpressionParserException(String message) {
        super(message);
    }

    public ExpressionParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionParserException(Throwable cause) {
        super(cause);
    }
}
