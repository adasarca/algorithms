package dynamicprogramming;

public class StringConvertion {

    public int operations (String str1, String str2) {
        //check empty string
        int n = str1.length();
        int m = str2.length();
        if (n == 0) {
            return m; //insert m chars
        }
        if (m == 0) {
            return n; //delete n chars
        }

        //init
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        //compute
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //choose min between delete, insert and replace
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }

        //return solution
        return dp[n][m];
    }

    private int min(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        StringConvertion stringConvertion = new StringConvertion();
        System.out.println(stringConvertion.operations(str1, str2));
    }
}
