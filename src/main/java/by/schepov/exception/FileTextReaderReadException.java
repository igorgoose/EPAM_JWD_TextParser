package by.schepov.exception;

public class FileTextReaderReadException extends Exception {
    public FileTextReaderReadException() {
    }

    public FileTextReaderReadException(String message) {
        super(message);
    }

    public FileTextReaderReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTextReaderReadException(Throwable cause) {
        super(cause);
    }
}
