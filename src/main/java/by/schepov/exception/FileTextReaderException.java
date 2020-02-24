package by.schepov.exception;

public class FileTextReaderException extends RuntimeException {
    public FileTextReaderException() {
    }

    public FileTextReaderException(String message) {
        super(message);
    }

    public FileTextReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTextReaderException(Throwable cause) {
        super(cause);
    }
}
