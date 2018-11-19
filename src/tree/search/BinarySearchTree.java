/**
 * Created by Ada.Sarca
 * Date: 9/3/2018
 */
package tree.search;

import tree.representation.BinaryNode;

public class BinarySearchTree { //todo: improve replaceWithSuccess from recap

    private BinaryNode root;

    public BinaryNode search(int value) {
        return this.search(this.root, value);
    }

    private BinaryNode search(BinaryNode node, int value) {
        if (null == node || node.getValue() == value) {
            return node;
        }

        if (node.getValue() < value) {
            return this.search(node.getRight(), value);
        }
        return this.search(node.getLeft(), value);
    }

    public void insert(int value) {
        this.root = this.insert(this.root, value);
    }

    private BinaryNode insert(BinaryNode node, int value) {
        if (null == node) {
            return new BinaryNode(value);
        }

        if (node.getValue() < value) {
            BinaryNode child = this.insert(node.getRight(), value);
            node.setRight(child);
        } else {
            BinaryNode child = this.insert(node.getLeft(), value);
            node.setLeft(child);
        }
        return node;
    }

    public void delete(int value) {
        this.root = this.delete(this.root, value);
    }

    private BinaryNode delete(BinaryNode node, int value) {
        if  (null == node) {
            return null;
        }

        if (node.getValue() == value) {
            //one or zero children
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }

            //two children
            return this.replaceWithSuccessor(node);
        }

        if (node.getValue() < value) {
            BinaryNode child = this.delete(node.getRight(), value);
            node.setRight(child);
        } else {
            BinaryNode child = this.delete(node.getLeft(), value);
            node.setLeft(child);
        }
        return node;
    }

    private BinaryNode replaceWithSuccessor(BinaryNode node) {
        BinaryNode successor = node.getRight();
        if (successor.getLeft() == null) {
            node.setValue(successor.getValue());
            node.setRight(null);
            return node;
        }

        BinaryNode parent;
        do {
            parent = successor;
            successor = successor.getLeft();
        } while (successor.getLeft() != null);
        node.setValue(successor.getValue());
        parent.setLeft(null);
        return node;
    }

    public void print() {
        this.inOrder(this.root);
        System.out.println();
    }

    private void inOrder(BinaryNode node) {
        if (null == node) {
            return;
        }

        this.inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        this.inOrder(node.getRight());
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(10);
        bst.insert(7);
        bst.insert(2);
        bst.insert(1);
        bst.insert(15);
        bst.print();

        System.out.println("Removing 10...");
        bst.delete(10);
        bst.print();

        System.out.println("Adding 8, 9 and 16...");
        bst.insert(8);
        bst.insert(9);
        bst.insert(16);
        bst.print();

        System.out.println("Removing 15...");
        bst.delete(15);
        bst.print();

        System.out.println("Searching 15...");
        BinaryNode node15 = bst.search(15);
        if (null == node15) {
            System.out.println("Not found");
        } else {
            System.out.println("Found");
        }

        System.out.println("Searching 9...");
        BinaryNode node9 = bst.search(9);
        if (null == node9) {
            System.out.println("Not found");
        } else {
            System.out.println("Found");
        }

        System.out.println("Adding 8 again...");
        bst.insert(8);
        bst.print();

        System.out.println("Removing 8...");
        bst.delete(8);
        bst.print();

        System.out.println("Removing 8 again...");
        bst.delete(8);
        bst.print();
    }
}
