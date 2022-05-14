package datastructure;

public class Operator {

    char operator;
    int priority;

    Operator(char operator) {
        this.operator = operator;
        switch (operator) {
            case '(':
                priority = 0;
                break;
            case '+':
            case '-':
                priority = 1;
                break;
            case '*':
            case '/':
                priority = 2;
                break;
            case ')': priority = 3;
                break;
        }
    }

}
