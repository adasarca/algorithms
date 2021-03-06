/**
 * Created by Ada.Sarca
 * Date: 9/3/2018
 */
package tree.traversal;

import tree.representation.GenericNode;

public class PreOrder {
    public void traverse(GenericNode node) {
        if (null == node) {
            return;
        }

        System.out.print(node.getValue() + " ");
        for (GenericNode child : node.getChildren()) {
            traverse(child);
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

        PreOrder preOrder = new PreOrder();
        preOrder.traverse(node0);
    }
}
