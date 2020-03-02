/*
 * Created by AdelaSarca
 * Date: 2/28/2020
 */
package recap.v2.dp;

import java.util.Arrays;
import java.util.Set;

public class CoinMinimum {

    public int min(int amount, Set<Integer> coins) {
        int[] min = new int[amount + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        for (Integer coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (min[i - coin] != Integer.MAX_VALUE && min[i - coin] + 1 < min[i]) {
                    min[i] = min[i - coin] + 1;
                }
            }
        }
        return min[amount];
    }
}
