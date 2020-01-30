/*
 * Created by AdelaSarca
 * Date: 1/30/2020
 */
package recap.v2;

import java.util.LinkedList;
import java.util.List;

public class ConnectedComponents {

    public List<List<Integer>> components(List<Integer>[] graph) {
        int n = graph.length;

        List<List<Integer>> components = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                LinkedList<Integer> component = new LinkedList<>();
                this.dfs(graph, i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] graph, Integer start, boolean[] visited, LinkedList<Integer> output) {
        visited[start] = true;
        output.add(start);
        for (Integer node : graph[start]) {
            if (!visited[node]) {
                this.dfs(graph, node, visited, output);
            }
        }
    }
}
