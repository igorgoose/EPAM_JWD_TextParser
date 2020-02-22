package by.schepov.exception;

public class InvalidBracketsPositionException extends Exception {
    public InvalidBracketsPositionException() {
    }

    public InvalidBracketsPositionException(String message) {
        super(message);
    }

    public InvalidBracketsPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBracketsPositionException(Throwable cause) {
        super(cause);
    }
}
