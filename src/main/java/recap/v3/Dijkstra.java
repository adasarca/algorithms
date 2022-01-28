package recap.v3;

import java.util.*;

public class Dijkstra {

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

        Dijkstra dijkstra = new Dijkstra();
        List<Integer> path = dijkstra.path(graph, 0, 9);

        for (int x : path)
            System.out.print(x + " ");
    }

    private static void addEdge(LinkedList<Node>[] graph, int x, int y, int cost) {
        graph[x].add(new Node(y, cost));
        graph[y].add(new Node(x, cost));
    }

    public List<Integer> path(LinkedList<Node>[] graph, int start, int end) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] pre = new int[n];
        pre[start] = -1;

        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(Node::getCost));
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node min = queue.poll();
            int x = min.getValue();

            if (visited[x])
                continue;
            visited[x] = true;

            for (Node node : graph[x]) {
                int y = node.getValue();
                if (!visited[y] && d[y] > d[x] + node.getCost()) {
                    d[y] = d[x] + node.getCost();
                    pre[y] = x;
                    queue.add(new Node(y, d[y]));
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        int x = end;
        while (x != -1) {
            path.addFirst(x);
            x = pre[x];
        }
        return path;
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
