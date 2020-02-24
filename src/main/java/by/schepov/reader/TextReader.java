package by.schepov.reader;

import by.schepov.exception.FileTextReaderReadException;

public interface TextReader {
    String read() throws FileTextReaderReadException;
}
