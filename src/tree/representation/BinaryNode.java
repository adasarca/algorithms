package tree.representation;

public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public void print() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.print();
        }
        if (this.right != null) {
            this.right.print();
        }
    }

    public static void main(String[] args) {
        BinaryNode node0 = new BinaryNode(0);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);

        node1.setLeft(node3);
        node1.setRight(node4);
        node0.setLeft(node1);
        node0.setRight(node2);

        node0.print();
    }
}
