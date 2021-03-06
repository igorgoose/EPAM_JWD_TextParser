package by.schepov.composite.impl;

import by.schepov.composite.TextComponent;

import java.util.List;

public class Character implements TextComponent {

    private char value;

    public Character()
    {

    }

    public Character(char value){
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException();
    }
}
