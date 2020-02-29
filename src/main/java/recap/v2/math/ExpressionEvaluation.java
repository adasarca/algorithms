package recap.v2.math;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation {

    public long evaluate(String s) {
        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
        priorityMap.put('(', 0);

        int n = s.length();
        Stack<Character> operands = new Stack<>();
        Stack<Long> numbers = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                long x = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    x = x * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numbers.push(x);
                i--;
            } else if (c == '(') {
                operands.push(c);
            } else if (c == ')') {
                while (operands.peek() != '(') {
                    this.computeNext(numbers, operands);
                }
                operands.pop();
            } else if (priorityMap.containsKey(c)) {
                while (!operands.isEmpty() && priorityMap.get(operands.peek()) >= priorityMap.get(c)) {
                    this.computeNext(numbers, operands);
                }
                operands.push(c);
            }
        }

        while (!operands.isEmpty()) {
            this.computeNext(numbers, operands);
        }
        return numbers.pop();
    }

    private void computeNext(Stack<Long> numbers, Stack<Character> operands) {
        long y = numbers.pop();
        long x = numbers.pop();
        char op = operands.pop();

        Long result = null;
        switch (op) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
        }
        if (result != null) {
            numbers.push(result);
        }
    }
}
