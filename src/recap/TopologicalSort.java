package recap;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    public List<Integer> sort(LinkedList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> sorted = new LinkedList<>();

        for(Integer node = 0; node < graph.length; node++) {
            if (!visited[node]) {
                this.dfs(graph, node, visited, sorted);
            }
        }

        return sorted;
    }

    private void dfs(LinkedList<Integer>[] graph, int node, boolean[] visited, LinkedList<Integer> output) {
        visited[node] = true;
        for(Integer neighbour : graph[node]) {
            if (!visited[neighbour]) {
                this.dfs(graph, neighbour, visited, output);
            }
        }
        output.push(node);
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(1);
        graph[1].add(2);
        graph[1].add(4);
        graph[1].add(5);
        graph[1].add(7);
        graph[2].add(3);
        graph[2].add(6);
        graph[3].add(8);
        graph[3].add(9);
        graph[5].add(8);
        graph[6].add(8);
        graph[6].add(9);
        graph[7].add(8);

        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> sorted = topologicalSort.sort(graph);
        sorted.forEach(node -> System.out.print(node + " "));
    }
}
