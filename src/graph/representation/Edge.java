/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

public class Edge {
    private int from;
    private int to;
    private int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
