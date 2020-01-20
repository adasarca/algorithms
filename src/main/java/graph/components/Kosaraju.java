/**
 * Created by Ada.Sarca
 * Date: 8/28/2018
 */
package graph.components;

import java.util.Arrays;
import java.util.LinkedList;

public class Kosaraju {

    public void components(LinkedList<Integer>[] graph) {
        //topological sort
        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                this.dfs(graph, i, visited, stack);
            }
        }

        //transpose
        LinkedList<Integer>[] transpose = this.transpose(graph);

        //dfs on transpose
        LinkedList<LinkedList<Integer>> scc = new LinkedList<>();
        Arrays.fill(visited, false);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                LinkedList<Integer> component = new LinkedList<>();
                this.dfs(transpose, node, visited, component);
                scc.add(component);
            }
        }

        //print scc
        System.out.println("Identified " + scc.size() + " components: ");
        for (LinkedList<Integer> component : scc) {
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private void dfs(LinkedList<Integer>[] graph, int start, boolean[] visited, LinkedList<Integer> stack) {
        visited[start] = true;

        for (int node : graph[start]) {
            if (!visited[node]) {
                this.dfs(graph, node, visited, stack);
            }
        }

        stack.push(start);
    }

    private LinkedList<Integer>[] transpose(LinkedList<Integer>[] graph) {
        int n = graph.length;
        LinkedList<Integer>[] transpose = new LinkedList[n];
        for (int i = 0; i< n; i++) {
            transpose[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                transpose[j].add(i);
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] adj = new LinkedList[8];
        for (int i = 0; i < 8; i++) {
            adj[i] = new LinkedList<>();
        }

        adj[0].add(7);
        adj[1].add(0);
        adj[1].add(2);
        adj[2].add(3);
        adj[2].add(4);
        adj[4].add(5);
        adj[5].add(2);
        adj[6].add(1);
        adj[7].add(6);

        Kosaraju kosaraju = new Kosaraju();
        kosaraju.components(adj);
    }
}
