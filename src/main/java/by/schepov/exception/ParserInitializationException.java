package by.schepov.exception;

public class ParserInitializationException extends Exception {
    public ParserInitializationException() {
    }

    public ParserInitializationException(String message) {
        super(message);
    }

    public ParserInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserInitializationException(Throwable cause) {
        super(cause);
    }
}
