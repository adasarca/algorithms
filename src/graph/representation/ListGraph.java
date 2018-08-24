/**
 * Created by Ada.Sarca
 * Date: 8/24/2018
 */
package graph.representation;

import java.util.LinkedList;

public class ListGraph {

    private int n;
    private LinkedList<Integer>[] adj;
    private boolean directed;

    public ListGraph(int n, boolean directed) {
        this.n = n;
        this.adj = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            this.adj[i] = new LinkedList<>();
        }
        this.directed = directed;
    }

    public void addEdge(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return;
        }

        this.adj[i].add(j);
        if (!this.directed && i != j) {
            this.adj[j].add(i);
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j : this.adj[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public LinkedList<Integer>[] getAdj() {
        return this.adj;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.print();
    }
}
