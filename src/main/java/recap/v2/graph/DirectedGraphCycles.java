package recap.v2.graph;

import java.util.List;

public class DirectedGraphCycles {

    public boolean hasCycles(List<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] != 2 && this.dfs(i, graph, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Integer start, List<Integer>[] graph, int[] visited) {
        if (visited[start] == 1) return true;

        visited[start] = 1;
        for (Integer node : graph[start]) {
            if (visited[node] != 2 && this.dfs(node, graph, visited)) {
                return true;
            }
        }
        visited[start] = 2;
        return false;
    }
}
