package by.schepov.reader.impl;

import by.schepov.exception.FileTextReaderException;
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
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String read() {
        try (FileReader reader = new FileReader(file)){
            StringBuilder builder = new StringBuilder();
            return Arrays.toString(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new FileTextReaderException(e);
        }
    }
}
