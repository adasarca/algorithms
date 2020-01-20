/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.representation;

public class WeightedMatrixGraph {

    private int n;
    private int[][] adj;
    private boolean directed;

    public WeightedMatrixGraph(int n, boolean directed) {
        this.n = n;
        this.adj = new int[n][n];
        this.directed = directed;
    }

    public void addEdge(int i, int j, int cost) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return;
        }

        this.adj[i][j] = cost;
        if (!this.directed) {
            this.adj[j][i] = cost;
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedMatrixGraph graph = new WeightedMatrixGraph(9, false);
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
