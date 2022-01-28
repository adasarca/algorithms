package recap.v3;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(2);
        bst.insert(10);
        bst.insert(1);
        bst.insert(4);
        bst.insert(5);
        bst.insert(10);
        bst.insert(9);
        bst.insert(14);
        bst.insert(13);
        bst.insert(11);
        bst.insert(12);
        bst.print();

        Node node = bst.search(10);
        bst.printInOrder(node);
        System.out.println();

        bst.remove(10);
        bst.print();

        System.out.println(bst.getHeight(bst.root));
        System.out.println(bst.getHeight(bst.root.left));
        System.out.println(bst.getHeight(bst.root.right));
    }

    private Node root;

    public Node search(int value) {
        return search(this.root, value);
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public void remove(int value) {
        this.root = remove(this.root, value);
    }

    public void print() {
        printInOrder(this.root);
        System.out.println();
    }

    private Node search(Node node, int value) {
        if (null == node)
            return null;

        if (node.getValue() == value)
            return node;

        if (value < node.getValue())
            return search(node.getLeft(), value);
        else
            return search(node.getRight(), value);
    }

    private Node insert(Node node, int value) {
        if (null == node)
            return new Node(value);

        if (value < node.getValue())
            node.setLeft(insert(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(insert(node.getRight(), value));

        return balance(node);
    }

    private Node remove(Node node, int value) {
        if (null == node)
            return null;

        if (value < node.getValue()) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(remove(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                node = node.getRight();
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else {
                node = replaceWithSuccessor(node);
            }
        }

        if (node == null)
            return null;

        return balance(node);
    }

    private Node replaceWithSuccessor(Node node) {
        Node successor = node.getRight();

        if (successor.getLeft() == null) {
            node.setValue(successor.getValue());
            node.setRight(successor.getRight());
            return node;
        }

        Node parent;
        do {
            parent = successor;
            successor = successor.getLeft();
        }
        while (successor.getLeft() != null);

        node.setValue(successor.getValue());
        parent.setLeft(successor.getRight());
        return node;
    }

    private Node balance(Node node) {
        int left = getHeight(node.getLeft());
        int right = getHeight(node.getRight());
        int diff = left - right;

        if (diff > 1) {
            if (getHeight(node.getLeft().getLeft()) - getHeight(node.getLeft().getRight()) < 0)
                node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        } else if (diff < -1) {
            if (getHeight(node.getRight().getLeft()) - getHeight(node.getRight().getLeft()) > 0)
                node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        node.setHeight(Math.max(left, right) + 1);
        return node;
    }

    private Node rotateRight(Node node) {
        Node r = node.getLeft();
        node.setLeft(r.getRight());
        r.setRight(node);

        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        r.setHeight(Math.max(getHeight(r.getLeft()), getHeight(r.getRight())) + 1);

        return r;
    }

    private Node rotateLeft(Node node) {
        Node r = node.getRight();
        node.setRight(r.getLeft());
        r.setLeft(node);

        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        r.setHeight(Math.max(getHeight(r.getLeft()), getHeight(r.getRight())) + 1);

        return r;
    }

    private int getHeight(Node node) {
        if (null == node)
            return 0;

        return node.getHeight();
    }

    private void printInOrder(Node node) {
        if (null == node)
            return;

        printInOrder(node.getLeft());

        System.out.print(node.getValue() + " ");

        printInOrder(node.getRight());
    }

    public static class Node {

        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
