package recap.v3;

import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[19];
        for (int i = 0; i < 19; i++)
            graph[i] = new LinkedList<>();

        addEdge(graph, 0, 4);
        addEdge(graph, 1, 5);
        addEdge(graph, 2, 6);
        addEdge(graph, 1, 10);
        addEdge(graph, 2, 11);
        addEdge(graph, 3, 7);
        addEdge(graph, 3, 12);
        addEdge(graph, 4, 9);
        addEdge(graph, 4, 13);
        addEdge(graph, 6, 14);
        addEdge(graph, 7, 16);
        addEdge(graph, 11, 14);
        addEdge(graph, 14, 15);
        addEdge(graph, 17, 18);

        ConnectedComponents connectedComponents = new ConnectedComponents();
        List<List<Integer>> components = connectedComponents.components(graph);

        for (List<Integer> component : components) {
            for (int x : component)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void addEdge(LinkedList<Integer>[] graph, int x, int y) {
        graph[x].add(y);
        graph[y].add(x);
    }

    public List<List<Integer>> components(LinkedList<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        List<List<Integer>> components = new LinkedList<>();
        for (int x = 0; x < n; x++)
            if (!visited[x]) {
                List<Integer> output = new LinkedList<>();
                this.dfs(x, graph, visited, output);
                components.add(output);
            }

        return components;
    }

    private void dfs(int start, LinkedList<Integer>[] graph, boolean[] visited, List<Integer> output) {
        visited[start] = true;
        output.add(start);

        for(int x : graph[start])
            if (!visited[x])
                dfs(x, graph, visited, output);
    }
}
