package by.schepov.reader.impl;

import by.schepov.exception.FileTextReaderException;
import by.schepov.exception.FileTextReaderReadException;
import by.schepov.reader.TextReader;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class FileTextReader implements TextReader {

    public static final String DEFAULT_FILENAME = "input.txt";

    private File file;

    public FileTextReader(){
        file = new File(getClass().getClassLoader().getResource("input.txt").getFile());
    }

    public FileTextReader(File file) throws FileTextReaderException {
        if(file == null){
            throw new FileTextReaderException();
        }
        this.file = file;
    }

    public void setFile(File file) {
        if(file == null){
            throw new FileTextReaderException();
        }
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String read() throws FileTextReaderReadException {
        try {
            return Arrays.toString(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new FileTextReaderReadException(e);
        }
    }
}
