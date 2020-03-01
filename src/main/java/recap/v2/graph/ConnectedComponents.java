package recap.v2.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponents {

    public List<List<Integer>> components(List<Integer>[] graph) {
        int n = graph.length;

        List<List<Integer>> components = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components.add(this.dfs(i, graph, visited));
            }
        }
        return components;
    }

    private List<Integer> dfs(Integer start, List<Integer>[] graph, boolean[] visited) {
        List<Integer> output = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            Integer x = stack.pop();
            if (visited[x]) continue;

            output.add(x);
            visited[x] = true;

            for (Integer node : graph[x]) {
                if (!visited[node]) {
                    stack.push(node);
                }
            }
        }
        return output;
    }
}
