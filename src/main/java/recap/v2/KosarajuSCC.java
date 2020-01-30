/*
 * Created by AdelaSarca
 * Date: 1/30/2020
 */
package recap.v2;

import java.util.LinkedList;
import java.util.List;

public class KosarajuSCC {

    public List<List<Integer>> scc(List<Integer>[] graph) {
        int n = graph.length;

        //topological sort
        boolean[] visited = new boolean[n];
        LinkedList<Integer> sorted = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.dfs(graph, i, visited, sorted);
            }
        }

        //build transpose
        List<Integer>[] transpose = new List[n];
        for (int i = 0; i < n; i++) {
            for (Integer node : graph[i]) {
                if (null == transpose[node]) {
                    transpose[node] = new LinkedList<>();
                }
                transpose[node].add(i);
            }
        }

        //build components
        visited = new boolean[n];
        List<List<Integer>> components = new LinkedList<>();
        for (Integer node : sorted) {
            if (!visited[node]) {
                LinkedList<Integer> component = new LinkedList<Integer>();
                this.dfs(transpose, node, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] graph, Integer start, boolean[] visited, LinkedList<Integer> output) {
        visited[start] = true;
        for (Integer node : graph[start]) {
            if (!visited[node]) {
                this.dfs(graph, node, visited, output);
            }
        }
        output.addFirst(start);
    }
}
