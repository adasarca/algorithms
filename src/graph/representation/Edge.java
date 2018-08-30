/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

public class Edge {
    private int node;
    private int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }
}
