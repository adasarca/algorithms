package dynamicprogramming;

import java.util.Arrays;

public class SumCoinMinimum {

    public int minimum(int sum, int[] coins) {
        //init
        int[] min = new int[sum + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        //compute
        for (int coin : coins) {
            for (int amount = coin; amount <= sum; amount++) {
                int previous = min[amount - coin];
                if (previous != Integer.MAX_VALUE && previous + 1 < min[amount]) {
                    min[amount] = previous + 1;
                }
            }
        }

        //return solution
        return min[sum];
    }

    public static void main(String[] args) {
        int sum = 12;
        int[] coins = new int[] {1,2,5};

        SumCoinMinimum sumCoins = new SumCoinMinimum();
        System.out.println(sumCoins.minimum(sum, coins));
    }
}
