package recap.v2.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    public List<Integer> bfs(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.bfs(i, graph, visited, output);
            }
        }
        return output;
    }

    private void bfs(Integer start, List<Integer>[] graph, boolean[] visited, List<Integer> output) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer x = queue.poll();
            output.add(x);

            for (Integer node : graph[start]) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    public List<Integer> dfs(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.dfs(i, graph, visited, output);
            }
        }
        return output;
    }

    private void dfs(Integer start, List<Integer>[] graph, boolean[] visited, List<Integer> output) {
        visited[start] = true;
        output.add(start);

        for (Integer node : graph[start]) {
            if (!visited[node]) {
                this.dfs(node, graph, visited, output);
            }
        }
    }

    public List<Integer> dfsIterative(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.dfsIterative(i, graph, visited, output);
            }
        }
        return output;
    }

    private void dfsIterative(Integer start, List<Integer>[] graph, boolean[] visited, List<Integer> output) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            Integer x = stack.pop();
            if (visited[x]) continue;

            visited[x] = true;
            output.add(x);

            for (Integer node : graph[x]) {
                if (!visited[node]) {
                    stack.push(node);
                }
            }
        }
    }
}
