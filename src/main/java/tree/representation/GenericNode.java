package tree.representation;

import java.util.LinkedList;

public class GenericNode {
    private int value;
    private LinkedList<GenericNode> children;

    public GenericNode(int value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    public void addChild(GenericNode node) {
        this.children.add(node);
    }

    public int getValue() {
        return value;
    }

    public LinkedList<GenericNode> getChildren() {
        return children;
    }

    public void print() {
        System.out.print(this.value + " ");
        for (GenericNode node : this.children) {
            node.print();
        }
    }

    public static void main(String[] args) {
        GenericNode node0 = new GenericNode(0);
        GenericNode node1 = new GenericNode(1);
        GenericNode node2 = new GenericNode(2);
        GenericNode node3 = new GenericNode(3);
        GenericNode node4 = new GenericNode(4);
        GenericNode node5 = new GenericNode(5);

        node1.addChild(node4);
        node3.addChild(node5);
        node0.addChild(node1);
        node0.addChild(node2);
        node0.addChild(node3);

        node0.print();
    }
}
