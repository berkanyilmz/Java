package datastructure;

public class Stack {
    Node top;

    Stack() {
        top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    Operator peek() {
        return top.operator;
    }

    void push(Node node) {
        if (isEmpty()) {
            top = node;
        } else {
            node.down = top;
            top = node;
        }
    }

    Node pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty !");
            return null;
        } else {
            Node deleted = top;
            top = top.down;
            return deleted;
        }
    }

    void show() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.operator.operator);
            temp = temp.down;
        }
    }

}
