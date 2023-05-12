package DataStructure;

public class LinkedList {
    Node head, tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isExist(String value) {
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                if (temp.varName.equals(value))
                    return true;
                temp = temp.next;
            }
        }
        return false;
    }

    public Node search(String value) {
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                if (temp.varName.equals(value))
                    return temp;
                temp = temp.next;
            }
        }
        return null;
    }

    public void addHead(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public Node addTail(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return tail;
    }

    public void add(Node node, String after) {
        if (isEmpty()) {
            head = null;
            tail = null;
        }
        else if (isExist(after)) {
            if (node.varName.equals(after))
                addHead(node);
            else if(node.varName.equals(tail.varName))
                addTail(node);
            else {
                Node temp = head;
                while (!temp.varName.equals(after))
                    temp = temp.next;

                node.next = temp.next;
                temp.next = node;
            }
        }
        else {
            System.out.println("Value is not in list !");
        }
    }

    public Node delHead() {
        if (isEmpty()) {
            System.out.println("List is empty !");
            return null;
        } else {
            Node deleted = head;
            head = head.next;
            return deleted;
        }
    }

    public Node delTail() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        else if(head.next == null) {
            Node deleted = head;
            head = null;
            tail = null;
            return deleted;
        }
        else {
            Node temp = head;

            while (temp.next.next != null)
                temp = temp.next;

            Node deleted = tail;
            tail = temp;
            tail.next = null;
            return deleted;
        }
    }

    public Node del(String value) {
        if (isEmpty()) {
            System.out.println("List is empty !");
            return null;
        }
        else if (isExist(value)) {
            Node previous = null;
            Node temp = head;

            while (!temp.varName.equals(value)) {
                previous = temp;
                temp = temp.next;
            }

            Node deleted = temp;
            previous.next = temp.next;
            return deleted;
        } else {
            System.out.println("Value is not in list");
            return null;
        }
    }

    public void show() {
        Node temp = head;

        while (temp != null) {
            System.out.println("id : " + temp.no);
            System.out.println("Var Name : " + temp.varName);
            System.out.println("Type : " + temp.type);
            temp = temp.next;
            System.out.println();
        }
    }
}
