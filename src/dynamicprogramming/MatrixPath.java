package dynamicprogramming;

public class MatrixPath {

    public void path(int[][] a) {
        //init
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n+1][m+1];

        //compute
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = a[i-1][j-1] + max(dp[i-1][j], dp[i][j-1]);
            }
        }

        //print
        System.out.println("Tokens: " + dp[n][m]);
        int i = n, j = m;
        while (i > 0 && j > 0) {
            System.out.println(i + " " + j);
            if (dp[i-1][j] > dp [i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 5, 3, 2},
                {4, 3, 2, 5},
                {10, 3, 2, 8},
                {1, 4, 2, 4}
        };
        MatrixPath matrixPath = new MatrixPath();
        matrixPath.path(a);
    }
}
