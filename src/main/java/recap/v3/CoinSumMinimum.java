package recap.v3;

import java.util.Arrays;

public class CoinSumMinimum {

    public static void main(String[] args) {
        CoinSumMinimum sumMinimum = new CoinSumMinimum();
        System.out.println(sumMinimum.minimum(5, new int[]{1, 2, 5}));
    }

    public int minimum(int sum, int[] coins) {
        int[] min = new int[sum + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        for (int coin : coins)
            for (int s = coin; s <= sum; s++) {
                int prev = min[s - coin];
                if (prev < Integer.MAX_VALUE && prev + 1 < min[s])
                    min[s] = prev + 1;
            }

        return min[sum];
    }
}
