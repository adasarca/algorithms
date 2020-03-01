package recap.v2.graph.paths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public int[] distance(List<Node>[] graph, int start) {
        int n = graph.length;
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getDistance));

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node x = queue.poll();
            if (visited[x.id]) continue;

            visited[x.id] = true;
            for (Node y : graph[x.id]) {
                if (d[x.id] + y.distance < d[y.id]) {
                    d[y.id] = d[x.id] + y.distance;
                    queue.add(new Node(y.id, d[y.id]));
                }
            }
        }
        return d;
    }
}
