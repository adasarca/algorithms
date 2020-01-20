package graph.path;

import graph.representation.Node;

import java.util.Arrays;
import java.util.LinkedList;

public class BellmanFordQueue {

    public void shortestPath(LinkedList<Node>[] graph, int source) {
        //init
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[graph.length];
        int[] visited = new int[graph.length];
        queue.add(source);
        inQueue[source] = true;

        //compute
        boolean negativeCycles = false;
        while (!queue.isEmpty()) {
            int x = queue.pop();
            inQueue[x] = false;
            visited[x]++;

            if (visited[x] == graph.length) {
                negativeCycles = true;
                break;
            }

            for (Node node : graph[x]) {
                Integer y = node.getValue();
                if (distance[y] > distance[x] + node.getCost()) {
                    distance[y] = distance[x] + node.getCost();
                    if (!inQueue[y]) {
                        queue.add(y);
                        inQueue[y] = true;
                    }
                }
            }
        }

        //print
        if (negativeCycles) {
            System.out.println("Graph contains negative weight cycles");
        } else {
            for (int d : distance) {
                System.out.print(d + " ");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Node>[] graph = new LinkedList[5];
        for(int i = 0; i < 5; i++) {
            graph[i] = new LinkedList<>();
        }
        graph[0].add(new Node(1, -1));
        graph[0].add(new Node(2, 4));
        graph[1].add(new Node(2, 3));
        graph[1].add(new Node(4, 2));
        graph[3].add(new Node(1, 1));
        graph[3].add(new Node(2, 5));
        graph[4].add(new Node(3, -3));


        BellmanFordQueue bellmanFord = new BellmanFordQueue();
        bellmanFord.shortestPath(graph, 0);
    }
}
