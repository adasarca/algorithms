package recap.v3;

import java.util.*;

public class ExpressionEvaluation {

    public static void main(String[] args) {
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        System.out.println(expressionEvaluation.calculate("4 + 5 * 2 - 10 / 5 * (1 + 2 * 2)"));
    }

    public int calculate(String s) {
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('+', 2);
        priority.put('-', 2);
        priority.put('(', 3);

        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c))
                continue;

            if (Character.isDigit(c)) {
                int x = c - '0';
                while(i < n - 1 && Character.isDigit(s.charAt(i + 1))) {
                    x = x * 10 + (s.charAt(i + 1) - '0');
                }
                numbers.push(x);
                continue;
            }

            if (c == '(')
                operators.push(c);
            else if (c == ')') {
                while (operators.peek() != '(')
                    this.calculate(numbers, operators);
                operators.pop();
            } else if (priority.containsKey(c)) {
                while(!operators.isEmpty() && priority.get(c) >= priority.get(operators.peek())) {
                    this.calculate(numbers, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty())
            this.calculate(numbers, operators);

        return numbers.pop();
    }

    private void calculate(Stack<Integer> numbers, Stack<Character> operators) {
        int x = numbers.pop();
        int y = numbers.pop();
        char op = operators.pop();

        switch (op) {
            case '+':
                numbers.push(x + y);
                break;
            case '-':
                numbers.push(y - x);
                break;
            case '*':
                numbers.push(x * y);
                break;
            case '/':
                numbers.push(y / x);
                break;
        }
    }
}
