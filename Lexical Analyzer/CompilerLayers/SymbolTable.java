package CompilerLayers;

import DataStructure.*;

public class SymbolTable {

    LinkedList list;
    int no;

    SymbolTable() {
        no = 0;
        allocate();
    }

    void allocate() {
        list = new LinkedList();
    }

    void free() {
        list = null;
    }

    Node insert(String varName, String type) {
        if (lookup(varName) == null) {
            no++;
            Node node = list.addTail(new Node(no, varName, type));
            return node;
        }
        else {
            System.out.println(varName + " variable is already exist !");
            return null;
        }
    }

    Node lookup(String varName) {
        Node node = list.search(varName);
        return node;
    }

    void set_attribute() {

    }

    Node get_attribute(String entry) {
        return lookup(entry);
    }

    void showTable() {
        list.show();
    }

}
