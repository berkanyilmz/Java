package DataStructure;

public class Node {
    public int no;
    public String type;
    public String varName;
    Node next;

    public Node(int no, String varName, String type) {
        this.no = no;
        this.varName = varName;
        this.type = type;
        next = null;
    }

}
