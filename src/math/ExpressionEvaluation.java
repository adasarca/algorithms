/**
 * Created by Ada.Sarca
 * Date: 10/3/2018
 */
package math;

import java.util.LinkedList;

public class ExpressionEvaluation {

    public Integer evaluate(String expression) {
        //init
        LinkedList<Integer> values = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();

        char[] chars = expression.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            //found blank char, skip it
            if (Character.isWhitespace(chars[i])) {
                continue;
            }

            //found number, push it to value stack
            if (Character.isDigit(chars[i])) {
                String number = String.valueOf(chars[i]);
                while(i < n - 1 && Character.isDigit(chars[i + 1])) {
                    number += chars[++i];
                };

                int value = this.convertInt(number);
                values.push(value);
                continue;
            }

            //found (, add it to operations stack
            if (chars[i] == '(') {
                operators.push(chars[i]);
                continue;
            }

            //found ), calculate operations between parentheses
            if (chars[i] == ')') {
                Character operator = operators.peek();
                while (operator != '(') {
                    this.calculateNext(values, operators);
                    operator = operators.peek();
                }
                operators.removeFirst();
                continue;
            }

            //found operator, calculate previous operations if their precedence is higher, then add operator to stack
            Character operator = operators.peek();
            while (operator != null && this.precedence(operator) >= this.precedence(chars[i])) {
                this.calculateNext(values, operators);
                operator = operators.peek();
            }
            operators.push(chars[i]);
        }

        //calculate remaining operations
        while (!operators.isEmpty()) {
            this.calculateNext(values, operators);
        }

        //return result
        return values.pop();
    }

    private void calculateNext(LinkedList<Integer> values, LinkedList<Character> operators) {
        Integer b = values.pop();
        Integer a = values.pop();
        Character operator = operators.pop();

        if (null == a || null == b || null == operator) {
            System.out.println("Invalid parameters, cannot calculate next operation");
            return;
        }

        Integer value= null;
        switch (operator) {
            case '+':
                value = a + b;
                break;
            case '-':
                value = a - b;
                break;
            case '*':
                value = a * b;
                break;
            case '/':
                value = a / b;
                break;
        }
        if (value == null) {
            System.out.println("Invalid operator, cannot calculate next operation");
            return;
        }

        values.push(value);
    }

    private int precedence(char operation) {
        switch (operation) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    private int convertInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        String expresion = "(1 + 1) * 13 + 10 / 2";
        int result = expressionEvaluation.evaluate(expresion);
        System.out.println(expresion + " = " + result);
    }
}
