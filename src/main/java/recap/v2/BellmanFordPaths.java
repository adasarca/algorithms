/*
 * Created by AdelaSarca
 * Date: 1/31/2020
 */
package recap.v2;

import java.util.Arrays;
import java.util.List;

public class BellmanFordPaths {

    public int[] paths(List<Node>[] graph, int source) {
        int n = graph.length;

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int k = 0; k < n-1; k++) {
            for (int i = 0; i < n; i++) {
                if (distance[i] == Integer.MAX_VALUE) continue;

                for (Node node : graph[i]) {
                    if (distance[node.id] > distance[i] + node.distance) {
                        distance[node.id] = distance[i] + node.distance;
                    }
                }
            }
        }

        //check for negative cycles
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) continue;

            for (Node node : graph[i]) {
                if (distance[node.id] > distance[i] + node.distance) {
                    return null;
                }
            }
        }
        return distance;
    }

    public static class Node {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
