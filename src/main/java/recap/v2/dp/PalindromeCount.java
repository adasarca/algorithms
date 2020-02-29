package recap.v2.dp;

public class PalindromeCount {

    public int count(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            pal[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                pal[i][i + 1] = true;
                count++;
            }
        }
        pal[n - 1][n - 1] = true;

        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                if (s.charAt(i) == s.charAt(i + k) && pal[i + 1][i + k - 1]) {
                    pal[i][i + k] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
