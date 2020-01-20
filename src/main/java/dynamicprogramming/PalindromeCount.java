package dynamicprogramming;

public class PalindromeCount {

    public int count(String s) {
        //init
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[][] dp = new int[n][n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }

        //compute
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                pal[i][i+1] = true;
                dp[i][i+1] = 1;
            }
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (chars[i] == chars[j] && pal[i+1][j-1]) {
                    pal[i][j] = true;
                }

                dp[i][j] = dp[i][j-1] + dp [i+1][j] - dp[i+1][j-1];
                if (pal[i][j]) {
                    dp[i][j]++;
                }
            }
        }

        //return
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "abaab";
        PalindromeCount palindromeCount = new PalindromeCount();
        System.out.println(s + " has " + palindromeCount.count(s) + " palindromes");
    }
}
