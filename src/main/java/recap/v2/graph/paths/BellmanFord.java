package recap.v2.graph.paths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFord {

    public int[] distances(List<Node>[] graph, int start) {
        int n = graph.length;

        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        int k = 0;
        boolean updated = true;
        while (k < n && updated) {
            updated = false;

            for (int i = 0; i < n; i++) {
                if (d[i] == Integer.MAX_VALUE) continue;

                for (Node node : graph[i]) {
                    if (d[i] + node.distance < d[node.id]) {
                        d[node.id] = d[i] + node.distance;
                        updated = true;
                    }
                }
            }

            k++;
        }

        if (k == n)
            return null;

        return d;
    }
}
