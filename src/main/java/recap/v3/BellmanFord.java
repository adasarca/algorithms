package recap.v3;

import java.util.*;

public class BellmanFord {

    public static void main(String[] args) {
        LinkedList<Node>[] graph = new LinkedList[5];
        for (int i = 0; i < 5; i++)
            graph[i] = new LinkedList<>();
        graph[0].add(new Node(1, -1));
        graph[0].add(new Node(2, 4));
        graph[1].add(new Node(2, 3));
        graph[1].add(new Node(4, 2));
        graph[3].add(new Node(1, 1));
        graph[3].add(new Node(2, 5));
        graph[4].add(new Node(3, -3));

        BellmanFord bellmanFord = new BellmanFord();
        List<Integer> path = bellmanFord.path(graph, 0, 4);

        if (path == null)
            System.out.println("Identified cycles");
        else for (int x : path)
            System.out.print(x + " ");
    }

    public List<Integer> path(List<Node>[] graph, int start, int end) {
        int n = graph.length;

        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        int[] pre = new int[n];
        pre[start] = -1;

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n];
        int[] visited = new int[n];

        queue.add(start);
        inQueue[start] = true;

        boolean hasCycles = false;
        while(!queue.isEmpty()) {
            int x = queue.pop();
            inQueue[x] = false;
            visited[x]++;

            if (visited[x] == n) {
                hasCycles = true;
                break;
            }

            for (Node node : graph[x]) {
                int y = node.getValue();
                if (d[y] > d[x] + node.getCost()) {
                    d[y] = d[x] + node.getCost();
                    pre[y] = x;
                    if (!inQueue[y]) {
                        inQueue[y] = true;
                        queue.add(y);
                    }
                }
            }
        }

        if (hasCycles)
            return null;

        int x = end;
        LinkedList<Integer> path = new LinkedList<>();
        while(x != -1) {
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
