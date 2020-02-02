package tree;

import java.util.LinkedList;
import java.util.List;

public class AvlTree {

    private Node root;

    public void insert(int value) {
        this.root = this.insert(this.root, value);
    }

    public boolean contains(int value) {
        Node node = this.root;
        while(node != null) {
            if (node.value == value) {
                return true;
            }
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public void delete(int value) {
        this.root = this.delete(this.root, value);
    }

    public List<Integer> asList() {
        List<Integer> list = new LinkedList<Integer>();
        this.inOrder(this.root, list);
        return list;
    }

    private Node insert(Node node, int value) {
        if (null == node) {
            return new Node(value);
        }
        if (node.value == value) {
            //no duplicates allowed
            return node;
        }

        if (node.value > value) {
            node.left = this.insert(node.left, value);
        } else {
            node.right = this.insert(node.right, value);
        }
        return this.balance(node);
    }

    private Node delete(Node node, int value) {
        if (null == node) {
            return null;
        }

        if (node.value == value) {
            if (null == node.left) {
                node = node.right;
            } else if (null == node.right) {
                node = node.left;
            } else {
                node = this.replaceWithSuccessor(node);
            }
        } else if (value < node.value) {
            node.left = this.delete(node.left, value);
        } else {
            node.right = this.delete(node.right, value);
        }

        if (null == node) {
            return null;
        }
        return this.balance(node);
    }

    private Node replaceWithSuccessor(Node node) {
        Node successor = node.right;
        if (null == successor.left) {
            successor.left = node.left;
            return successor;
        }

        Node parent;
        do {
            parent = successor;
            successor = successor.left;
        } while (successor.left != null);

        parent.left = successor.right;
        node.value = successor.value;
        return successor;
    }

    private int getHeight(Node node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    private Node balance(Node node) {
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        int diff = left - right;
        if (diff > 1) {
            if (getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                node.left = this.rotateLeft(node.left);
            }
            return this.rotateRight(node);
        }
        if (diff < -1) {
            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                node.right = this.rotateRight(node.right);
            }
            return this.rotateLeft(node);
        }
        node.height = Math.max(left, right) + 1;
        return node;
    }

    private Node rotateLeft(Node node) {
        Node root = node.right;
        node.right = root.left;
        root.left = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    private Node rotateRight(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    private void inOrder(Node node, List<Integer> output) {
        if (null == node) return;

        this.inOrder(node.left, output);
        output.add(node.value);
        this.inOrder(node.right, output);
    }

    private static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }
}
