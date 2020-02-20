package by.schepov.composite.impl;


import by.schepov.composite.TextComponent;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {

    private LinkedList<TextComponent> children;

    private TextCompositeType type;

    public TextComposite(){
        children = new LinkedList<TextComponent>();
    }

    public TextComposite(TextCompositeType type){
        this.type = type;
    }

    public void add(TextComponent component){
        children.add(component);
    }

    public List<TextComponent> getChildren(){
        return children;
    }

    public TextCompositeType getType() {
        return type;
    }

    public void setType(TextCompositeType type) {
        this.type = type;
    }

    public void execute() {

    }
}
