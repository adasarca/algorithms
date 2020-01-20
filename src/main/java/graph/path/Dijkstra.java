/**
 * Created by Ada.Sarca
 * Date: 8/28/2018
 */
package graph.path;

import graph.representation.Node;

import java.util.LinkedList;

public class Dijkstra {
    public void shortestPath(LinkedList<Node>[] graph, int source) {
        //init
        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        //compute
        for (int count = 0; count < graph.length - 1; count++) {
            int x = minDistance(distance, visited);
            if (distance[x] == Integer.MAX_VALUE) {
                break;
            }

            visited[x] = true;
            for (Node node : graph[x]) {
                int y = node.getValue();
                if (!visited[y] && distance[y] > distance[x] + node.getCost()) {
                    distance[y] = distance[x] + node.getCost();
                }
            }
        }

        //print
        for (int i = 0; i < graph.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int  i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LinkedList<Node>[] graph = new LinkedList[11];
        for (int i = 0; i < 11; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(new Node(1, 4));
        graph[0].add(new Node(7, 8));
        graph[1].add(new Node(0, 4));
        graph[1].add(new Node(2, 8));
        graph[1].add(new Node(7, 11));
        graph[2].add(new Node(1, 8));
        graph[2].add(new Node(3, 7));
        graph[2].add(new Node(5, 4));
        graph[2].add(new Node(8, 2));
        graph[3].add(new Node(2, 7));
        graph[3].add(new Node(4, 9));
        graph[3].add(new Node(5, 14));
        graph[4].add(new Node(3, 9));
        graph[4].add(new Node(5, 10));
        graph[5].add(new Node(2, 4));
        graph[5].add(new Node(3, 14));
        graph[5].add(new Node(4, 10));
        graph[5].add(new Node(6, 2));
        graph[6].add(new Node(5, 2));
        graph[6].add(new Node(7, 1));
        graph[6].add(new Node(8, 6));
        graph[7].add(new Node(0, 8));
        graph[7].add(new Node(1, 11));
        graph[7].add(new Node(6, 1));
        graph[7].add(new Node(8, 7));
        graph[8].add(new Node(2, 2));
        graph[8].add(new Node(6, 6));
        graph[8].add(new Node(7, 7));
        graph[9].add(new Node(10, 5));
        graph[10].add(new Node(9, 5));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.shortestPath(graph, 0);
    }
}
