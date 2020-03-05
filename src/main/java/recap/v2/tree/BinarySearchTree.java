package recap.v2.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public boolean contains(T value) {
        return this.contains(this.root, value);
    }

    public void add(T value) {
        this.root = this.add(this.root, value);
    }

    public void remove(T value) {
        this.root = this.remove(this.root, value);
    }

    public List<T> asList() {
        List<T> list = new ArrayList<>();
        this.inOrder(root, list);
        return list;
    }

    private boolean contains(Node<T> node, T value) {
        if (null == node) return false;

        int c = value.compareTo(node.value);
        if (c == 0) {
            return true;
        } else if (c < 0) {
            return this.contains(node.left, value);
        } else {
            return this.contains(node.right, value);
        }
    }

    private Node<T> add(Node<T> node, T value) {
        if (null == node) return new Node<>(value);

        int c = value.compareTo(node.value);
        if (c < 0) {
            node.left = this.add(node.left, value);
        } else if (c > 0) {
            node.right = this.add(node.right, value);
        }
        return node;
    }

    private Node<T> remove(Node<T> node, T value) {
        if (null == node) return null;

        int c = value.compareTo(node.value);
        if (c == 0) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                return replaceWithSuccessor(node);
            }
        }

        if (c < 0) {
            node.left = this.remove(node.left, value);
        } else {
            node.right = this.remove(node.right, value);
        }
        return node;
    }

    private Node<T> replaceWithSuccessor(Node<T> node) {
        Node<T> successor = node.right;
        if (successor.left == null) {
            successor.left = node.left;
            return successor;
        }

        Node<T> parent;
        do {
            parent = successor;
            successor = successor.left;
        }
        while(successor.left != null);

        parent.left = successor.right;
        successor.right = node.right;
        successor.left = node.left;
        return successor;
    }

    private void inOrder(Node<T> node, List<T> output) {
        if (null == node) return;
        this.inOrder(node.left, output);
        output.add(node.value);
        this.inOrder(node.right, output);
    }

    private static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
}
