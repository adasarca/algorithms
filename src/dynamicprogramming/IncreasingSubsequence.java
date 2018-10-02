/**
 * Created by Ada.Sarca
 * Date: 10/2/2018
 */
package dynamicprogramming;

import util.PrintUtil;

public class IncreasingSubsequence {

    public int[] longest(int[] a) {
        //init
        int n = a.length;
        int[] dp = new int[n];
        int[] pre = new int[n];

        //compute dp
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) {
                maxi = i;
            }
        }

        //build solution
        int[] solution = new int[dp[maxi]];
        int i = maxi;
        while (i != -1) {
            solution[dp[i] - 1] = a[i];
            i = pre[i];
        }
        return solution;
    }

    public static void main(String[] args) {
        IncreasingSubsequence increasingSubsequence = new IncreasingSubsequence();
        int[] a = new int[]{24, 12, 15, 15, 19};
        int[] lis = increasingSubsequence.longest(a);
        System.out.println("Longest increasing subsequence:");
        PrintUtil.print(lis);
    }
}
