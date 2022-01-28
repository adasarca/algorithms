package recap.v3;

import graph.representation.EdgeGraph;

import java.util.*;

public class MstKruskal {

    public static void main(String[] args) {
        List<Edge> graph = new LinkedList<>();
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(1, 2, 1));
        graph.add(new Edge(2, 3, 4));
        graph.add(new Edge(3, 4, 1));
        graph.add(new Edge(4, 5, 2));
        graph.add(new Edge(5, 6, 3));
        graph.add(new Edge(6, 2, 2));
        graph.add(new Edge(1, 3, 2));
        graph.add(new Edge(0, 2, 3));
        graph.add(new Edge(1, 5, 2));
        graph.add(new Edge(6, 4, 1));

        MstKruskal mstKruskal = new MstKruskal();
        List<Edge> mst = mstKruskal.mst(graph, 7);
        for (Edge edge : mst)
            System.out.println(edge.getFrom() + " " + edge.getTo() + " " + edge.getWeight());
    }

    public List<Edge> mst(List<Edge> graph, int nodes) {
        graph.sort(Comparator.comparing(Edge::getWeight));
        int[] parent = new int[nodes];
        int[] rank = new int[nodes];

        for (int  i =0; i < nodes; i++)
            parent[i] = i;

        List<Edge> mst = new LinkedList<>();
        Iterator<Edge> iterator = graph.iterator();
        while(mst.size() < nodes - 1 && iterator.hasNext()) {
            Edge edge = iterator.next();
            int x = edge.getFrom();
            int y = edge.getTo();

            int setX = findSet(x, parent);
            int setY = findSet(y, parent);
            if (setX == setY)
                continue;

            mst.add(edge);
            if (rank[setX] > rank[setY])
                parent[setY] = setX;
            else {
                parent[setX] = setY;
                if(rank[setX] == rank[setY])
                    rank[setY]++;
            }
        }

        return mst;
    }

    private int findSet(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = findSet(parent[x], parent);
        return parent[x];
    }

    public static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }
}
