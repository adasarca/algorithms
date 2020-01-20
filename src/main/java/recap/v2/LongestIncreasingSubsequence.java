/*
 * Created by AdelaSarca
 * Date: 1/20/2020
 */
package recap.v2;

public class LongestIncreasingSubsequence {

    public int[] sequence(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int[] pre = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[max]) {
                max = i;
            }
        }

        int k = dp[max];
        int[] res = new int[k];
        int i = max;
        while(i > -1) {
            res[--k] = a[i];
            i = pre[i];
        }
        return res;
    }
}
