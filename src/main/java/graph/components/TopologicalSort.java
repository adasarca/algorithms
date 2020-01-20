/**
 * Created by Ada.Sarca
 * Date: 8/28/2018
 */
package graph.components;

import java.util.LinkedList;

public class TopologicalSort {

    public void sort(LinkedList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                this.dfs(graph, i, visited, stack);
            }
        }

        for (int node : stack) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    private void dfs(LinkedList<Integer>[] graph, int start, boolean[] visited, LinkedList<Integer> stack){
        visited[start] = true;

        for (int node : graph[start]) {
            if (!visited[node]) {
                this.dfs(graph, node, visited, stack);
            }
        }

        stack.push(start);
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(1);
        graph[1].add(2);
        graph[1].add(4);
        graph[1].add(5);
        graph[1].add(7);
        graph[2].add(3);
        graph[2].add(6);
        graph[3].add(8);
        graph[3].add(9);
        graph[5].add(8);
        graph[6].add(8);
        graph[6].add(9);
        graph[7].add(8);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.sort(graph);
    }
}
