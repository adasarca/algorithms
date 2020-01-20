/*
 * Created by AdelaSarca
 * Date: 1/20/2020
 */
package recap.v2;

public class CommonSubsequence {

    public String longest(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] > dp[i - 1][j] ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }

        int k = dp[n][m];
        char[] res = new char[k];
        int i = n, j = m;
        while(k > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res[--k] = s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(res);
    }
}
