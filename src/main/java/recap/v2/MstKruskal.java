/*
 * Created by AdelaSarca
 * Date: 1/31/2020
 */
package recap.v2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MstKruskal {

    public int mst(List<Node>[] graph) {
        int n = graph.length;

        List<Edge> edges = new LinkedList<Edge>();
        int[] set = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
            for (Node node : graph[i]) {
                if (node.id > i) { //add edge once
                    edges.add(new Edge(i, node.id, node.cost));
                }
            }
        }

        Collections.sort(edges);

        int result = 0;
        for (Edge edge : edges) {
            int setX = this.findSet(set, edge.x);
            int setY = this.findSet(set, edge.y);

            if (setX == setY) continue; //cycle detected

            //add to mst
            result += edge.cost;

            //union
            if (rank[setY] > rank[setX]) {
                set[setY] = setX;
            } else {
                set[setX] = setY;
                if (rank[setX] == rank[setY]) {
                    rank[setY]++;
                }
            }
        }
        return result;
    }

    private int findSet(int[] set, int node) {
        if (node != set[node]) {
            set[node] = this.findSet(set, set[node]);
        }
        return set[node];
    }

    public static class Node {
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
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

        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}
