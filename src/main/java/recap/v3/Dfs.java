package recap.v3;

import java.util.*;

public class Dfs {

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[13];
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 2, 6);
        addEdge(graph, 3, 5);
        addEdge(graph, 3, 7);
        addEdge(graph, 4, 10);
        addEdge(graph, 4, 12);
        addEdge(graph, 5, 9);
        addEdge(graph, 6, 8);
        addEdge(graph, 7, 8);
        addEdge(graph, 7, 9);
        addEdge(graph, 8, 11);
        addEdge(graph, 10, 11);

        Dfs dfs = new Dfs();
        List<Integer> output = dfs.traverse(graph);
        for (int x : output)
            System.out.print(x + " ");
    }

    private static void addEdge(LinkedList<Integer>[] graph, int x, int y) {
        if (graph[x] == null)
            graph[x] = new LinkedList<>();

        if (graph[y] == null)
            graph[y] = new LinkedList<>();

        graph[x].add(y);
        graph[y].add(x);
    }

    public List<Integer> traverse(LinkedList<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<Integer> output = new LinkedList<>();

        for (int x = 0; x < n; x++)
            if (!visited[x])
                dfs(x, graph, visited, output);

        return output;
    }

    private void dfs(int start, LinkedList<Integer>[] graph, boolean[] visited, List<Integer> output) {
        visited[start] = true;
        output.add(start);
        for (Integer x : graph[start]) {
            if (!visited[x])
                dfs(x, graph, visited, output);
        }
    }
}
