package graph.components;

import java.util.LinkedList;

public class ConnectedComponents {

    public void components(LinkedList<Integer>[] adj) {
        //init
        int[] visited = new int[adj.length];
        int components = 0;

        //dfs
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                components++;
                this.dfs(adj, i, components, visited);
            }
        }

        //print
        System.out.println("Identified " + components + " components");
        for (int i = 0; i < adj.length; i++) {
            System.out.print(visited[i] + " ");
        }
    }

    private void dfs(LinkedList<Integer>[] adj, int start, int component, int[] visited) {
        visited[start] = component;

        for (Integer node : adj[start]) {
            if (visited[node] == 0) {
                this.dfs(adj, node, component, visited);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] adj = new LinkedList[10];
        for(int i = 0; i < 10; i++) {
            adj[i] = new LinkedList<>();
        }

        adj[0].add(6);
        adj[0].add(7);
        adj[1].add(9);
        adj[2].add(4);
        adj[3].add(6);
        adj[3].add(7);
        adj[4].add(2);
        adj[4].add(5);
        adj[5].add(4);
        adj[6].add(0);
        adj[6].add(3);
        adj[7].add(0);
        adj[7].add(3);
        adj[7].add(8);
        adj[8].add(7);
        adj[9].add(1);

        ConnectedComponents connectedComponents = new ConnectedComponents();
        connectedComponents.components(adj);
    }
}
