package recap.v3;

public class MatrixPath {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,1,1,3,1,0,2},
                {0,0,0,2,1,0,3,1},
                {1,2,0,1,2,1,0,1},
                {0,3,1,2,1,0,0,1},
                {8,2,1,1,1,3,1,2},
                {0,3,5,0,2,0,1,1},
                {2,1,1,3,1,0,2,0},
                {3,0,2,4,2,1,0,2},
                {2,1,3,1,0,0,3,1}
        };

        MatrixPath matrixPath = new MatrixPath();
        int[][] path = matrixPath.path(a);
        for (int[] row : path)
            System.out.println(row[0] + " " + row[1]);
    }

    public int[][] path(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + a[i - 1][j - 1];
            }
        }

        int[][] res = new int[n + m - 1][2];
        int k = n + m - 2;
        int i = n, j = m;
        while (k >= 0) {
            res[k][0] = i - 1;
            res[k][1] = j - 1;
            k--;

            if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return res;
    }
}
