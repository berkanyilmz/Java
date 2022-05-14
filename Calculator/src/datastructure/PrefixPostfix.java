package datastructure;

import java.lang.reflect.Type;

public class PrefixPostfix {

    static Stack stack = null;
    String expression;
    Operator operator;

    public PrefixPostfix() {
        stack = new Stack();
        expression = "";
    }

    boolean isOperator(char chr) {
        return chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '%' || chr == '(' || chr == ')';
    }


    public String infixToPostfix(String infixExpression) {
        int len = infixExpression.length();
        for (int i = 0; i < len; i++) {
            if (isOperator(infixExpression.charAt(i))) {
                expression += " ";
                if (infixExpression.charAt(i) == ')') {
                    while (stack.peek().operator != '(') {
                        expression += stack.pop().operator.operator + " ";
                    }
                    stack.pop();
                }
                else if (infixExpression.charAt(i) == '(') {
                    stack.push(new Node(new Operator('(')));
                }
                else { // is not ')'
                    operator = new Operator(infixExpression.charAt(i));
                    while (!stack.isEmpty() && stack.peek().priority >= operator.priority) {
                        expression += stack.pop().operator.operator + " ";
                    }
                    stack.push(new Node(operator));
                }
            }
            else { // is not operator
                expression += infixExpression.charAt(i);
            }
        }
        while (!stack.isEmpty()) {
            expression += " " + stack.pop().operator.operator;
        }
        System.out.println("Expression : " + expression );
        return expression;
    }


    public int postfixCalculation(String postfixExpression) {
        int t1, t2, t3 = 0;
        String str = "";
        for (int i = 0; i < postfixExpression.length(); i++) {
            if ('0' <= postfixExpression.charAt(i) && postfixExpression.charAt(i) <= '9') {
                str += Character.getNumericValue(postfixExpression.charAt(i));
            }
            else if (postfixExpression.charAt(i) == ' ' && !str.equals("")) {
                int val = Integer.parseInt(str);
                stack.push(new Node(val));
                str = "";
            }
            else if (isOperator(postfixExpression.charAt(i))) {
                t1 = stack.pop().value;
                t2 = stack.pop().value;
                switch (postfixExpression.charAt(i)) {
                    case '+':
                        t3 = t2 + t1;
                        break;
                    case '-':
                        t3 = t2 - t1;
                        break;
                    case '*':
                        t3 = t2 * t1;
                        break;
                    case '/':
                        t3 = t2 / t1;
                        break;
                }
                stack.push(new Node(t3));
            }
        }
        int result = stack.pop().value;
        expression = "";
        return result;
    }

}
