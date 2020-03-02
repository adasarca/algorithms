/*
 * Created by AdelaSarca
 * Date: 2/28/2020
 */
package recap.v2.dp;

import java.util.Set;

public class CoinSumCombinations {

    public int combinations(int amount, Set<Integer> coins) {
        int[] comb = new int[amount + 1];
        comb[0] = 1;

        for (Integer coin : coins) {
            for (int i = coin; i <= amount; i++) {
                comb[i] += comb[i - coin];
            }
        }
        return comb[amount];
    }
}
