package datastructure;

public class Node {
    Operator operator;
    int value;
    Node down;

    public Node(Operator opr) {
        operator = opr;
        down = null;
    }

    public Node(int value) {
        this.value = value;
        down = null;
    }
}
