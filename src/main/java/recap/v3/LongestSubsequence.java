package recap.v3;

public class LongestSubsequence {

    public static void main(String[] args) {
        int[] a = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};

        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int[] seq = longestSubsequence.longest(a);

        for (int x : seq)
            System.out.print(x + " ");
    }

    public int[] longest(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[max])
                max = i;
        }

        int k = dp[max];
        int[] seq = new int[k];
        int i = max;
        while(i != -1) {
            seq[--k] = a[i];
            i = pre[i];
        }

        return seq;
    }
}
