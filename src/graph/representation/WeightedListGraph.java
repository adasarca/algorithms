/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

import java.util.LinkedList;

public class WeightedListGraph {
    private int n;
    private LinkedList<Edge>[] adj;
    private boolean directed;

    public WeightedListGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int x, int y, int weight) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }

        this.adj[x].add(new Edge(y, weight));
        if (!this.directed) {
            adj[y].add(new Edge(x, weight));
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Edge edge : this.adj[i]) {
                System.out.print(edge.getNode() + " (" + edge.getCost() + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedListGraph graph = new WeightedListGraph(9, false);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        graph.print();
    }
}
