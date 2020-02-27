/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
package recap.v2.dp;

public class LongestCommonSubstring {

    public String common(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        int maxi = 0;
        int maxj = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > dp[maxi][maxj]) {
                        maxi = i;
                        maxj = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder solution = new StringBuilder();
        int i = maxi, j = maxj;
        while (i > 0 && j > 0 && s1.charAt(i - 1) == s2.charAt(j - 1)) {
            solution.insert(0, s1.charAt(i - 1));
            i--;
            j--;
        }
        return solution.toString();
    }
}
