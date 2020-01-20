/**
 * Created by Ada.Sarca
 * Date: 9/3/2018
 */
package tree.traversal;

import tree.representation.BinaryNode;

public class InOrder {

    public void traverse(BinaryNode node) {
        if (null == node) {
            return;
        }

        this.traverse(node.getLeft());
        System.out.print(node.getValue() + " ");
        this.traverse(node.getRight());
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

        InOrder inOrder = new InOrder();
        inOrder.traverse(node0);
    }
}
