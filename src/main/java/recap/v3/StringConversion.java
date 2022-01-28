package recap.v3;

public class StringConversion {

    public static void main(String[] args) {
        StringConversion stringConversion = new StringConversion();
        System.out.println(stringConversion.operations("sunday", "saturday"));
    }

    public int operations(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++)
            dp[i][0] = i;

        for(int j = 0; j <= n2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n1; i++)
            for (int j = 1; j <= n2; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }

        return dp[n1][n2];
    }
}
