package recap.v3;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "children";

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.common(s1, s2));
    }

    public String common(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n1, j = n2;
        while (dp[i][j] > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }

        return sb.toString();
    }
}
