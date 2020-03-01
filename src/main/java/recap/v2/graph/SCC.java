package recap.v2.graph;

import java.util.LinkedList;
import java.util.List;

public class SCC {

    public List<LinkedList<Integer>> components(List<Integer>[] graph) {
        int n = graph.length;
        List<Integer>[] transpose = new LinkedList[n];

        boolean[] visited = new boolean[n];
        LinkedList<Integer> sorted = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            transpose[i] = new LinkedList<>();
            if (!visited[i]) {
                this.dfs(i, graph, visited, sorted);
            }
        }

        for (int i = 0; i < n; i++) {
            for (Integer j : graph[i]) {
                transpose[j].add(i);
            }
        }

        List<LinkedList<Integer>> components = new LinkedList<>();
        visited = new boolean[n];
        for (Integer node : sorted) {
            if (!visited[node]) {
                LinkedList<Integer> component = new LinkedList<>();
                this.dfs(node, transpose, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void dfs(Integer start, List<Integer>[] graph, boolean[] visited, LinkedList<Integer> output) {
        visited[start] = true;
        for (Integer node : graph[start]) {
            if (!visited[node]) {
                this.dfs(node, graph, visited, output);
            }
        }
        output.addFirst(start);
    }
}
