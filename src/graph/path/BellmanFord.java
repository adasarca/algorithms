/**
 * Created by Ada.Sarca
 * Date: 8/30/2018
 */
package graph.path;

import graph.representation.Edge;

import java.util.Arrays;
import java.util.LinkedList;

public class BellmanFord {

    public void shortestPath(int nodes, LinkedList<Edge> graph, int source) {
        int[] distance = new int[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        //compute
        for (int i = 0; i < nodes - 1; i++) {
            for (Edge edge : graph) {
                if (distance[edge.getFrom()] == Integer.MAX_VALUE) continue;

                if (distance[edge.getFrom()] + edge.getCost() < distance[edge.getTo()]) {
                    distance[edge.getTo()] = distance[edge.getFrom()] + edge.getCost();
                }
            }
        }

        //check for negative cycles
        boolean cycles = false;
        for (Edge edge : graph) {
            if (distance[edge.getFrom()] == Integer.MAX_VALUE) continue;

            if (distance[edge.getFrom()] + edge.getCost() < distance[edge.getTo()]) {
                cycles = true;
                break;
            }
        }

        //print
        if (!cycles) {
            for (int i = 0; i < nodes; i++) {
                System.out.print(distance[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Graph contains negative weight cycles");
        }
    }

    public static void main(String[] args) {
        LinkedList<Edge> graph = new LinkedList<>();
        graph.add(new Edge(0, 1, -1));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, 3));
        graph.add(new Edge(1, 3, 2));
        graph.add(new Edge(1, 4, 2));
        graph.add(new Edge(3, 1, 1));
        graph.add(new Edge(3, 2, 5));
        graph.add(new Edge(4, 3, -3));

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.shortestPath(5, graph, 0);
    }
}
