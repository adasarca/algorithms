package graph.path;

public class FloydWarshall {

    public void shortestPath(int[][] graph) {
        //init
        int n = graph.length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    distance[i][j] = graph[i][j];
                } else if (i != j) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //compute
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE &&
                            distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        //print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[6][6];
        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[0][4] = 3;
        graph[4][0] = 3;
        graph[1][2] = 2;
        graph[2][1] = 2;
        graph[1][3] = 5;
        graph[3][1] = 5;
        graph[1][4] = 1;
        graph[4][1] = 1;
        graph[2][3] = 2;
        graph[3][2] = 2;
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.shortestPath(graph);
    }
}
