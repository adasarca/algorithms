/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

public class Node {
    private int value;
    private int cost;

    public Node(int value, int cost) {
        this.value = value;
        this.cost = cost;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }
}
