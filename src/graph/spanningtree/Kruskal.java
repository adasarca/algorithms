package graph.spanningtree;

import graph.representation.Edge;

import java.util.*;

public class Kruskal {

    public void mst(List<Edge> graph, int nodes) {
        //init
        List<Edge> mst = new LinkedList<>();
        int[] setParent = new int[nodes];
        int[] setRank = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            setParent[i] = i;
        }

        //sort edges
        Collections.sort(graph);

        //build mst
        int count = 0;
        Iterator<Edge> iterator = graph.iterator();
        while(count < nodes - 1 && iterator.hasNext()) {
            Edge edge = iterator.next();
            int x = edge.getFrom();
            int y = edge.getTo();

            //detect cycle
            int setX = this.findSet(setParent, x);
            int setY = this.findSet(setParent, y);
            if (setX == setY) {
                continue;
            }

            //add to mst
            mst.add(edge);
            count++;

            //merge disjoint sets
            if (setRank[setX] > setRank[setY]) {
                setParent[setY] = setX;
            } else {
                setParent[setX] = setY;
                if (setRank[setX] == setRank[setY]) {
                    setRank[setY]++;
                }
            }
        }

        //print
        for (Edge edge : mst) {
            System.out.println(edge.getFrom() + " " + edge.getTo() + " (" + edge.getCost() + ")");
        }
    }

    private int findSet(int[] parent, int element) {
        if (parent[element] != element) {
            parent[element] = findSet(parent, parent[element]);
        }
        return parent[element];
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
        kruskal.mst(graph, 9);
    }
}
