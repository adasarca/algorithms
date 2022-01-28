package recap.v3;

import java.util.LinkedList;

public class DirectedGraphCycles {

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[8];
        for(int i = 0; i < 8; i++)
            graph[i] = new LinkedList<>();

        graph[1].add(2);
        graph[1].add(4);
        graph[2].add(3);
        graph[2].add(7);
        graph[3].add(6);
        graph[5].add(6);
        graph[6].add(1);

        DirectedGraphCycles directedGraphCycles = new DirectedGraphCycles();
        System.out.println(directedGraphCycles.hasCycles(graph));
    }

    public boolean hasCycles(LinkedList<Integer>[] graph) {
        int n = graph.length;
        int[] visited = new int[n];

        for(int x = 0; x < n; x++)
            if (visited[x] != 2 && hasCycles(x, graph, visited))
                return true;

        return false;
    }

    private boolean hasCycles(int start, LinkedList<Integer>[] graph, int[] visited) {
        if (visited[start] == 1)
            return true;

        visited[start] = 1;
        for (int x : graph[start]) {
            if (visited[x] != 2 && hasCycles(x, graph, visited))
                return true;
        }

        visited[start] = 2;
        return false;
    }
}
