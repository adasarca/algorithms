/**
 * Created by Ada.Sarca
 * Date: 10/2/2018
 */
package dynamicprogramming;

public class CommonSubsequence {

    public String longest(String str1, String str2) {
        //init
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        //compute dp[][]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char x = str1.charAt(i - 1);
                char y = str2.charAt(j - 1);

                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        //build solution
        StringBuilder solution = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            char x = str1.charAt(i - 1);
            char y = str2.charAt(j - 1);
            if (x == y) {
                solution.insert(0, x);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return solution.toString();
    }

    private int max (int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        CommonSubsequence commonSubsequence = new CommonSubsequence();
        String str1 = "abcdgh";
        String str2 = "aedfhr";        ;
        System.out.println("Longest common subsequence: " + commonSubsequence.longest(str1, str2));
    }
}
