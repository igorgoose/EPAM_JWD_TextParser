package by.schepov.composite;

import java.util.List;

public interface TextComponent {
    void sort();
    List<TextComponent> getChildren();
}
