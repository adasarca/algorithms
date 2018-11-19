/**
 * Created by Ada.Sarca
 * Date: 11/19/2018
 */
package recap;

import graph.representation.Edge;

import java.util.*;

public class Kruskal {

    public List<Edge> mst(List<Edge> edges, int nodes) {
        LinkedList<Edge> mst = new LinkedList<>();
        int[] parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }
        int[] ranking = new int[nodes];

        edges.sort(Comparator.comparing(Edge::getCost));
        int count = 0;
        Iterator<Edge> iterator = edges.iterator();
        while(count < nodes - 1 && iterator.hasNext()) {
            Edge edge = iterator.next();
            Integer x = edge.getFrom();
            Integer y = edge.getTo();

            //detect cycle
            int rootX = this.find(x, parent);
            int rootY = this.find(y, parent);
            if (rootX == rootY) {
                continue;
            }

            //add to mst
            mst.add(edge);
            this.union(rootX, rootY, parent, ranking);
            count++;
        }
        return mst;
    }

    private int find(int element,int[] parent) {
        if (parent[element] != element) {
            parent[element] = this.find(parent[element], parent);
        }
        return parent[element];
    }

    private void union(int x, int y, int[] parent, int[] ranking) {
        if (ranking[x] > ranking[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            if (ranking[x] == ranking[y]) {
                ranking[y]++;
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> graph = new LinkedList<>();
        graph.add(new Edge(0,1,4));
        graph.add(new Edge(0,7,8));
        graph.add(new Edge(1,2,8));
        graph.add(new Edge(1,7,11));
        graph.add(new Edge(2,3,7));
        graph.add(new Edge(2,5,4));
        graph.add(new Edge(2,8,2));
        graph.add(new Edge(3,4,9));
        graph.add(new Edge(3,5,14));
        graph.add(new Edge(4,5,10));
        graph.add(new Edge(5,6,2));
        graph.add(new Edge(6,7,1));
        graph.add(new Edge(6,8,6));
        graph.add(new Edge(7,8,7));

        Kruskal kruskal = new Kruskal();
        List<Edge> mst = kruskal.mst(graph, 9);
        mst.forEach(System.out::println);
    }
}
