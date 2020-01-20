package recap.v1;

/*
* Example: a = {1,2,3,4,5,6,7,8,9}, b = {2,-1,-3,4,1,6,8} => {2,4,6,8}
* dp[i][j] = longest sequence for a[0..i] and b[0..j]
* dp[i][j] = dp[i-1][j-1] + 1 (if a[i] = b[j]) or max(dp[i-1][j], dp[i][j-1]) otherwise
* */
public class LongestCommonSubsequence {
    public int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char x = a.charAt(i - 1);
                char y = b.charAt(j - 1);
                if (x == y) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs("abcdgh", "aedfhr"));
    }
}
