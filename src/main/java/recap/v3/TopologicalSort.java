package recap.v3;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[6];
        for (int x = 0; x < 6; x++)
            graph[x] = new LinkedList<>();
        graph[2].add(3);
        graph[3].add(1);
        graph[4].add(0);
        graph[4].add(1);
        graph[5].add(0);
        graph[5].add(2);

        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> sorted = topologicalSort.sort(graph);

        for(int x : sorted)
            System.out.print(x + " ");
    }

    public List<Integer> sort(LinkedList<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        LinkedList<Integer> output = new LinkedList<>();
        for (int x = 0; x < n; x++)
            if (!visited[x])
                dfs(x, graph, visited, output);

        return output;
    }

    private void dfs(int start, LinkedList<Integer>[] graph, boolean[] visited, LinkedList<Integer> output) {
        visited[start] = true;

        for (int x : graph[start])
            if (!visited[x])
                dfs(x, graph, visited, output);

        output.addFirst(start);
    }
}
