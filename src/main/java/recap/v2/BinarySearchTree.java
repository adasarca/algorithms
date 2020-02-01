package recap.v2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree {

    public Node find(Node tree, int value) {
        Node node = tree;
        while (node != null) {
            if (node.value == value) {
                return node;
            }

            if (node.value > value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public Node insert(Node node, int value) {
        if (null == node) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = this.insert(node.left, value);
        } else {
            node.right = this.insert(node.right, value);
        }
        return node;
    }

    public Node delete(Node node, int value) {
        if (null == node) {
            return null;
        }

        if (node.value == value) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                return this.replaceWithSuccessor(node);
            }
        }

        if (node.value > value) {
            node.left = this.delete(node.left, value);
        } else {
            node.right = this.delete(node.right, value);
        }

        return node;
    }

    public List<Integer> getList(Node node) {
        List<Integer> list = new LinkedList<>();
        this.inOrder(node, list);
        return list;
    }

    private Node replaceWithSuccessor(Node node) {
        Node successor = node.getRight();
        if (successor.getLeft() == null) {
            successor.setLeft(node.getLeft());
            return successor;
        }

        Node parent;
        do {
            parent = successor;
            successor = successor.getLeft();
        } while (successor.getLeft() != null);

        node.setValue(successor.getValue());
        parent.setLeft(successor.getRight());
        return node;
    }

    private void inOrder(Node node, List<Integer> output) {
        if (null == node) return;

        this.inOrder(node.left, output);
        output.add(node.value);
        this.inOrder(node.right, output);
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Node)) return false;

            Node node = (Node) o;
            if (this == o) return true;

            if (this.value != node.value) return false;
            if (this.left != null ? !this.left.equals(node.left) : node.left != null) return false;
            if (this.right != null ? !this.right.equals(node.right) : node.right != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }
}
