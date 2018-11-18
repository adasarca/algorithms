package recap;

import util.PrintUtil;

import java.util.LinkedList;

public class ConnectedComponents {

    public void print(LinkedList<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int components = 0;

        for (int node = 0; node < n; node ++) {
            if (visited[node] == 0) {
                dfs(graph, node, visited, ++components);
            }
        }

        PrintUtil.print(visited);
    }

    private void dfs(LinkedList<Integer>[] graph, int node, int[] visited, int component) {
        visited[node] = component;
        for (Integer neighbour : graph[node]) {
            if (visited[neighbour] == 0) {
                this.dfs(graph, neighbour, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[10];
        for(int i = 0; i < 10; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(6);
        graph[0].add(7);
        graph[1].add(9);
        graph[2].add(4);
        graph[3].add(6);
        graph[3].add(7);
        graph[4].add(2);
        graph[4].add(5);
        graph[5].add(4);
        graph[6].add(0);
        graph[6].add(3);
        graph[7].add(0);
        graph[7].add(3);
        graph[7].add(8);
        graph[8].add(7);
        graph[9].add(1);

        ConnectedComponents connectedComponents = new ConnectedComponents();
        connectedComponents.print(graph);
    }
}
