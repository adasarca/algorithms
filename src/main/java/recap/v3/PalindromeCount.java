package recap.v3;

public class PalindromeCount {

    public static void main(String[] args) {
        PalindromeCount palindromeCount = new PalindromeCount();
        System.out.println(palindromeCount.count("abanoncdlacal"));
    }

    public int count(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            pal[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                pal[i][i + 1] = true;
                dp[i][i + 1] = 1;
            }
        }
        pal[n - 1][n - 1] = true;

        for (int gap = 2; gap < n; gap++)
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];

                if (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]) {
                    pal[i][j] = true;
                    dp[i][j]++;
                }
            }

        return dp[0][n - 1];
    }
}
