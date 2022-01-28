package recap.v3;

import java.util.*;

public class SCC {

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[5];
        for (int x = 0; x < 5; x++)
            graph[x] = new LinkedList<>();

        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(0);
        graph[3].add(0);
        graph[4].add(3);

        SCC scc = new SCC();
        List<List<Integer>> components = scc.components(graph);

        for (List<Integer> c : components) {
            for (int x : c)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> components(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        LinkedList<Integer> sorted = new LinkedList<>();
        List<Integer>[] transpose = new LinkedList[n];
        for (int x = 0; x < n; x++) {
            transpose[x] = new LinkedList<>();

            if (!visited[x])
                dfs(x, graph, visited, sorted);
        }

        for (int x = 0; x < n; x++)
            for (int y : graph[x])
                transpose[y].add(x);
        Arrays.fill(visited, false);

        List<List<Integer>> components = new LinkedList<>();
        for (int x : sorted)
            if (!visited[x]) {
                LinkedList<Integer> component = new LinkedList<>();
                dfs(x, transpose, visited, component);
                components.add(component);
            }
        return components;
    }

    private void dfs(int start, List<Integer>[] graph, boolean[] visited, LinkedList<Integer> output) {
        visited[start] = true;

        for (int x : graph[start])
            if (!visited[x])
                dfs(x, graph, visited, output);

        output.addFirst(start);
    }
}
