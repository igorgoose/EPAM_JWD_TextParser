package by.schepov.exception;

public class PolishNotationConverterException extends Exception {
    public PolishNotationConverterException() {
    }

    public PolishNotationConverterException(String message) {
        super(message);
    }

    public PolishNotationConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PolishNotationConverterException(Throwable cause) {
        super(cause);
    }
}
