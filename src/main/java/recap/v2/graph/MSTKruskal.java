/*
 * Created by AdelaSarca
 * Date: 3/2/2020
 */
package recap.v2.graph;

import recap.v2.MstKruskal;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MSTKruskal {

    public int mst(List<MstKruskal.Node>[] graph) {
        int n = graph.length;
        int[] set = new int[n];
        int[] rank = new int[n];

        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (MstKruskal.Node node : graph[i]) {
                if (node.id > i) {
                    edges.add(new Edge(i, node.id, node.cost));
                }
            }
            set[i] = i;
        }

        Collections.sort(edges);

        int mst = 0;
        for (Edge edge : edges) {
            int x = edge.x;
            int y = edge.y;

            //identify cycles
            int setX = this.getSet(x, set);
            int setY = this.getSet(y, set);
            if (setX == setY) continue;

            //add to mst
            mst += edge.cost;

            //union
            if (rank[setX] > rank[setY]) {
                set[setY] = setX;
            } else {
                set[setX] = setY;
                if (rank[setX] == rank[setY]) {
                    rank[setY]++;
                }
            }
        }
        return mst;
    }

    private int getSet(int z, int[] set) {
        if (set[z] != z) {
            set[z] = getSet(set[z], set);
        }
        return set[z];
    }

    public static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
