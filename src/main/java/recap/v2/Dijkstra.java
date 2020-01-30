/*
 * Created by AdelaSarca
 * Date: 1/30/2020
 */
package recap.v2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public int[] distance(List<Node>[] graph, Integer start, Integer end) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.value]) continue;

            visited[node.value] = true;
            for (Node x : graph[node.value]) {
                if (distance[x.value] > distance[node.value] + x.distance) {
                    distance[x.value] = distance[node.value] + x.distance;
                    queue.add(new Node(x.value, distance[x.value]));
                }
            }
        }

        //unreachable
        return distance;
    }

    public static class Node implements Comparable<Node> {
        int value;
        int distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
