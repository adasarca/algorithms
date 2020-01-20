package recap.v1;

import java.util.HashMap;
import java.util.Stack;

/*
* 2 stacks: operators and values
* foreach item: if value => add to values, if ( => add to operators, if ) => calculate until (,
* if operator => calculate operations with higher precedence, then add to operators stack
*
*
* */
public class ExpressionEvaluation {

    public int calculate(String expression) {
        char[] chars = expression.toCharArray();
        int n = chars.length;

        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0);

        Stack<Character> operators = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (Character.isWhitespace(chars[i])) {
                continue;
            }

            if (Character.isDigit(chars[i])) {
                int number = chars[i] - '0';
                while(i < n - 1 && Character.isDigit(chars[i + 1])) {
                    number = number * 10 + (chars[++i] - '0');
                }
                values.push(number);
                continue;
            }

            if (chars[i] == '(') {
                operators.push(chars[i]);
                continue;
            }

            if (chars[i] == ')') {
                while(operators.peek() != '(') {
                    this.calculate(values, operators);
                }
                operators.pop();
            }

            Integer p = precedence.get(chars[i]);
            if (p != null) {
                while(!operators.isEmpty() && p <= precedence.get(operators.peek())) {
                    this.calculate(values, operators);
                }
                operators.push(chars[i]);
            }
        }
        while(!operators.isEmpty()) {
            this.calculate(values, operators);
        }
        return values.pop();
    }

    private void calculate(Stack<Integer> values, Stack<Character> operators) {
        Integer b = values.pop();
        Integer a = values.pop();
        Character operator = operators.pop();

        Integer result = null;
        switch (operator) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
        }

        if (result != null) {
            values.push(result);
        }
    }

    public static void main(String[] args) {
        String expresion = "(1 + 1) * 13 + 10 / 2";
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        System.out.println(expresion + " = " + expressionEvaluation.calculate(expresion));
    }
}
