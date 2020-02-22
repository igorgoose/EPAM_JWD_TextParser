package by.schepov.exception;

public class InvalidOperatorCharacterException extends RuntimeException {
    public InvalidOperatorCharacterException() {
    }

    public InvalidOperatorCharacterException(String message) {
        super(message);
    }

    public InvalidOperatorCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperatorCharacterException(Throwable cause) {
        super(cause);
    }
}
