/**
 * Created by Ada.Sarca
 * Date: 8/24/2018
 */
package graph.traversal;

import graph.representation.ListGraph;

import java.util.LinkedList;

public class BreadthFirstSearch {

    public void bfs(LinkedList<Integer>[] adj, int start) {
        boolean[] visited = new boolean[adj.length];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.push(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer x = queue.pop();
            System.out.print(x + " ");

            for (Integer y : adj[x]) {
                if (!visited[y]) {
                    queue.add(y);
                    visited[y] = true;
                }
            }
        }
        System.out.println();
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

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(graph.getAdj(), 0);
    }
}
