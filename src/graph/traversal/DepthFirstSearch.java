/**
 * Created by Ada.Sarca
 * Date: 8/24/2018
 */
package graph.traversal;

import graph.representation.ListGraph;

import java.util.LinkedList;

public class DepthFirstSearch {

    public void dfs(LinkedList<Integer>[] adj, int start) {
        boolean[] visited = new boolean[adj.length];
        this.dfs(adj, start, visited);
        System.out.println();
    }

    private void dfs(LinkedList<Integer>[] adj, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (Integer node : adj[start]) {
            if (!visited[node]) {
                this.dfs(adj, node, visited);
            }
        }
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.print();

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(graph.getAdj(), 0);
    }
}
