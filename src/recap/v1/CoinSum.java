package recap.v1;

/*
* Having a sum S and an infinite supply of coins M, how many ways to make up S are there?
* combinations[sum] when adding a coin = combinations[sum - coin] + combinations[sum];
*
* */
public class CoinSum {

    public int combinations(int sum, int[] coins) {
        int[] combinations = new int[sum + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int s = coin; s <= sum; s++) {
                combinations[s] += combinations[s - coin];
            }
        }

        return combinations[sum];
    }

    public static void main(String[] args) {
        int sum = 12;
        int[] coins = new int[] {1,2,5};

        CoinSum coinSum = new CoinSum();
        System.out.println(coinSum.combinations(sum, coins));
    }
}
