package by.schepov.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExpressionPolishNotationConverter {
    private ExpressionPolishNotationConverter() {

    }

    public static List<String> getPolishNotation(String expression) {
        //todo validation
        Deque<String> stack = new ArrayDeque<>();
        int currentIndex = 0;
        int lastReadIndex = -1;
        int expressionLength = expression.length();
        while (currentIndex < expressionLength) {

        }
        return null;
    }
}
