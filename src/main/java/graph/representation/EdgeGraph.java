/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

import java.util.LinkedList;

public class EdgeGraph {
    int n;
    private LinkedList<Edge> edges;

    public EdgeGraph(int n) {
        this.n = n;
        this.edges = new LinkedList<>();
    }

    public void addEdge(int x, int y, int cost) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }

        this.edges.add(new Edge(x, y, cost));
    }

    public void print() {
        for (Edge edge : this.edges) {
            System.out.println(edge.getFrom() + ", " + edge.getTo() + ": " + edge.getCost());
        }
    }

    public static void main(String[] args) {
        EdgeGraph graph = new EdgeGraph(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 1, 4);
        graph.print();
    }
}
