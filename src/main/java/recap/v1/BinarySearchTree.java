/**
 * Created by Ada.Sarca
 * Date: 11/19/2018
 */
package recap.v1;

import tree.representation.BinaryNode;

/*
* lookup, insert, delete
* elements from left are less than root
* insert always as leaf (if not balanced)
* on delete, check children: 0 = delete, 1 = replace with child, 2 = replace with successor (min child from right tree)
* on replace with successor: if right child is min => replace. else: if min has right child: add as left to parent
* */
public class BinarySearchTree {

    private BinaryNode root;

    public BinaryNode insert(int value) {
        this.root = this.insert(value, this.root);
        return this.root;
    }

    public BinaryNode search(int value) {
        return this.search(value, this.root);
    }

    public BinaryNode delete(int value) {
        this.root = this.delete(value, this.root);
        return this.root;
    }

    public void print() {
        this.print(this.root);
        System.out.println();
    }

    private BinaryNode insert(int value, BinaryNode node) {
        if (null == node) {
            return new BinaryNode(value);
        }
        if (value < node.getValue()) {
            BinaryNode child = this.insert(value, node.getLeft());
            node.setLeft(child);
        } else {
            BinaryNode child = this.insert(value, node.getRight());
            node.setRight(child);
        }
        return node;
    }

    private BinaryNode search(int value, BinaryNode node) {
        if (node == null) {
            return null;
        }
        if (value == node.getValue()) {
            return node;
        }
        if (value < node.getValue()) {
            return this.search(value, node.getLeft());
        }
        return this.search(value, node.getRight());
    }

    private BinaryNode delete(int value, BinaryNode node) {
        if (node == null) {
            return null;
        }

        if (value == node.getValue()) {
            //0 or 1 child
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }

            //2 children
            return this.replaceWithSuccessor(node);
        }

        if (value < node.getValue()) {
            BinaryNode child = this.delete(value, node.getLeft());
            node.setLeft(child);

        } else {
            BinaryNode child = this.delete(value, node.getRight());
            node.setRight(child);
        }
        return node;
    }

    private BinaryNode replaceWithSuccessor(BinaryNode node) {
        BinaryNode parent = node.getRight();
        if (parent.getLeft() == null) {
            parent.setLeft(node.getLeft());
            return parent;
        }

        BinaryNode child = parent.getLeft();
        while (child.getLeft() != null) {
            parent = child;
            child = parent.getLeft();
        }

        node.setValue(child.getValue());
        if (child.getRight() != null) {
            parent.setLeft(child.getRight());
        } else {
            parent.setLeft(null);
        }
        return node;
    }

    private void print(BinaryNode node) {
        if (node == null) {
            return;
        }
        this.print(node.getLeft());
        System.out.print(node.getValue() + " ");
        this.print(node.getRight());
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
