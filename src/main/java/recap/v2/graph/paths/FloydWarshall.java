package recap.v2.graph.paths;

import java.util.Arrays;
import java.util.List;

public class FloydWarshall {

    public int[][] distances(List<Node>[] graph) {
        int n = graph.length;
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
            for (Node node : graph[i]) {
                d[i][node.id] = node.distance;
            }
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (i != j && i != k && k != j &&
                            d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE &&
                            d[i][k] + d[k][j] < d[i][j])
                        d[i][j] = d[i][k] + d[k][j];

        return d;
    }
}
