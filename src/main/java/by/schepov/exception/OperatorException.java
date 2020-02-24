package by.schepov.exception;

public class OperatorException extends Exception {
    public OperatorException() {
    }

    public OperatorException(String message) {
        super(message);
    }

    public OperatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperatorException(Throwable cause) {
        super(cause);
    }
}
