package recap;

import graph.representation.Node;
import util.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
*
*
*
* */
public class Dijkstra {

    public int[] shortestPath(LinkedList<Node>[] graph, int start) {
        //init
        int n = graph.length;
        boolean[] visited = new boolean[n];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparing(Node::getCost));
        pq.add(new Node(start, 0));

        //calculate
        while(!pq.isEmpty()) {
            Node min = pq.poll();
            Integer x = min.getValue();
            if (visited[x]) continue;

            visited[x] = true;
            for (Node node : graph[x]) {
                Integer y = node.getValue();
                if (!visited[y] && distance[y] > distance[x] + node.getCost()) {
                    distance[y] = distance[x] + node.getCost();
                    pq.add(new Node(y, distance[y]));
                }
            }
        }

        //return
        return distance;
    }

    public static void main(String[] args) {
        LinkedList<Node>[] graph = new LinkedList[11];
        for (int i = 0; i < 11; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(new Node(1, 4));
        graph[0].add(new Node(7, 8));
        graph[1].add(new Node(0, 4));
        graph[1].add(new Node(2, 8));
        graph[1].add(new Node(7, 11));
        graph[2].add(new Node(1, 8));
        graph[2].add(new Node(3, 7));
        graph[2].add(new Node(5, 4));
        graph[2].add(new Node(8, 2));
        graph[3].add(new Node(2, 7));
        graph[3].add(new Node(4, 9));
        graph[3].add(new Node(5, 14));
        graph[4].add(new Node(3, 9));
        graph[4].add(new Node(5, 10));
        graph[5].add(new Node(2, 4));
        graph[5].add(new Node(3, 14));
        graph[5].add(new Node(4, 10));
        graph[5].add(new Node(6, 2));
        graph[6].add(new Node(5, 2));
        graph[6].add(new Node(7, 1));
        graph[6].add(new Node(8, 6));
        graph[7].add(new Node(0, 8));
        graph[7].add(new Node(1, 11));
        graph[7].add(new Node(6, 1));
        graph[7].add(new Node(8, 7));
        graph[8].add(new Node(2, 2));
        graph[8].add(new Node(6, 6));
        graph[8].add(new Node(7, 7));
        graph[9].add(new Node(10, 5));
        graph[10].add(new Node(9, 5));

        Dijkstra dijkstra = new Dijkstra();
        int[] distances = dijkstra.shortestPath(graph, 0);
        PrintUtil.print(distances);
    }
}
