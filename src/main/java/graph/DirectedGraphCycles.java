/*
 * Created by AdelaSarca
 * Date: 1/29/2020
 */
package graph;

import java.util.List;

public class DirectedGraphCycles {

    public boolean hasCycles(List<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 2 && this.hasCycles(graph, i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycles(List<Integer>[] graph, Integer start, int[] visited) {
        if (visited[start] == 1) {
            return true;
        }

        visited[start] = 1;
        for (Integer node : graph[start]) {
            if (visited[node] != 2 && this.hasCycles(graph, node, visited)) {
                return true;
            }
        }
        visited[start] = 2;
        return false;
    }
}
