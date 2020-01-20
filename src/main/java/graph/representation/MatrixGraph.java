/**
 * Created by Ada.Sarca
 * Date: 8/24/2018
 */
package graph.representation;

public class MatrixGraph {

    private int n;
    private int[][] adj;
    private boolean directed;

    public MatrixGraph(int n, boolean directed) {
        this.n = n;
        this.adj = new int[n][n];
        this.directed = directed;
    }

    public void addEdge(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return;
        }

        this.adj[i][j] = 1;
        if (!this.directed) {
            this.adj[j][i] = 1;
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

    public int[][] getAdj() {
        return this.adj;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.print();
    }
}
