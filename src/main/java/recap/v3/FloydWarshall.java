package recap.v3;

import java.util.Arrays;
import java.util.LinkedList;

public class FloydWarshall {

    public static void main(String[] args) {
        LinkedList<Node>[] graph = new LinkedList[10];
        for (int i = 0; i < 10; i++)
            graph[i] = new LinkedList<>();
        addEdge(graph, 0, 1, 3);
        addEdge(graph, 0, 7, 1);
        addEdge(graph, 1, 2, 4);
        addEdge(graph, 1, 6, 3);
        addEdge(graph, 2, 9, 2);
        addEdge(graph, 3, 5, 1);
        addEdge(graph, 3, 8, 1);
        addEdge(graph, 4, 5, 4);
        addEdge(graph, 4, 6, 3);
        addEdge(graph, 4, 8, 2);
        addEdge(graph, 5, 9, 2);
        addEdge(graph, 6, 7, 5);
        addEdge(graph, 6, 9, 4);
        addEdge(graph, 7, 8, 2);

        FloydWarshall floydWarshall = new FloydWarshall();
        int[][] d = floydWarshall.distances(graph);

        for (int[] dd : d) {
            for (int x : dd)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void addEdge(LinkedList<Node>[] graph, int x, int y, int cost) {
        graph[x].add(new Node(y, cost));
        graph[y].add(new Node(x, cost));
    }

    public int[][] distances(LinkedList<Node>[] graph) {
        int n = graph.length;
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
        }

        for (int i = 0; i < n; i++)
            for (Node node : graph[i])
                d[i][node.getValue()] = node.getCost();

        for (int k = 0; k < n; k++)
            for (int x = 0; x < n; x++)
                for (int y = 0; y < n; y++)
                    if (d[x][k] != Integer.MAX_VALUE && d[k][y] != Integer.MAX_VALUE &&
                            d[x][k] + d[k][y] < d[x][y])
                        d[x][y] = d[x][k] + d[k][y];

        return d;
    }

    public static class Node {
        private int value;
        private int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        public int getValue() {
            return value;
        }

        public int getCost() {
            return cost;
        }
    }
}
