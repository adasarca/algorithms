/**
 * Created by Ada.Sarca
 * Date: 9/3/2018
 */
package tree.traversal;

import tree.representation.GenericNode;

import java.util.LinkedList;

public class LevelOrder {

    public void traverse(GenericNode start) {
        LinkedList<GenericNode> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            GenericNode node = queue.pop();
            System.out.print(node.getValue() + " ");
            for (GenericNode child : node.getChildren()) {
                queue.add(child);
            }
        }
    }

    public void traverseLevel(GenericNode node, int level) {
        if (level <= 0) {
            return;
        }

        if (level == 1) {
            System.out.print(node.getValue() + " ");
        }

        for (GenericNode child : node.getChildren()) {
            traverseLevel(child, level - 1);
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

        LevelOrder levelOrder = new LevelOrder();
        levelOrder.traverse(node0);
        System.out.println();

        System.out.print("Level 3: ");
        levelOrder.traverseLevel(node0, 3);
    }
}
