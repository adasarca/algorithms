/*
 * Created by AdelaSarca
 * Date: 1/28/2020
 */
package graph;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    public List<Integer> sort(List<Integer>[] graph) {
        int n = graph.length;

        LinkedList<Integer> output = new LinkedList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, i, output, visited)) {
                return null;
            }
        }
        return output;
    }

    private boolean dfs(List<Integer>[] graph, Integer start, LinkedList<Integer> output, int[] visited) {
        if (visited[start] == 2) {
            return true;
        }

        if (visited[start] == 1) {
            return false; //cycle detected
        }

        visited[start] = 1;
        if (graph[start] != null) {
            for (Integer node : graph[start]) {
                if (!dfs(graph, node, output, visited)) {
                    return false;
                }
            }
        }
        visited[start] = 2;
        output.addFirst(start);
        return true;
    }
}
