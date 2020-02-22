package by.schepov.composite.impl;

public enum TextCompositeType {
    TEXT("(.+)(\n*\t*)"),
    PARAGRAPH("([^\\.!?]+)([\\.?!]+)(\\s*)"),
    SENTENCE("([\\s\\.?!-]*)([^\\s\\.?!-]+)([\\s\\.?!-]*)"),
    LEXEME("(\\w|\\W)");

    TextCompositeType(String regex){
        this.regex = regex;
    }

    private String regex;

    public String getRegex(){
        return regex;
    }
}
