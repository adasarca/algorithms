package recap.v2.graph;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    public List<Integer> sort(List<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        LinkedList<Integer> output = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] != 2 && !this.dfs(i, graph, visited, output)) {
                return null;
            }
        }
        return output;
    }

    private boolean dfs(Integer start, List<Integer>[] graph, int[] visited, LinkedList<Integer> output) {
        if (visited[start] == 1) return false;

        visited[start] = 1;
        for (Integer node : graph[start]) {
            if (visited[node] != 2 && !this.dfs(node, graph, visited, output)) {
                return false;
            }
        }
        visited[start] = 2;
        output.addFirst(start);
        return true;
    }
}
