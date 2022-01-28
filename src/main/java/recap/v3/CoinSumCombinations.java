package recap.v3;

public class CoinSumCombinations {

    public static void main(String[] args) {
        CoinSumCombinations coinSumCombinations = new CoinSumCombinations();
        System.out.println(coinSumCombinations.combinations(5, new int[]{1, 2, 5}));
    }

    public int combinations(int sum, int[] coins) {
        int[] combinations = new int[sum + 1];
        combinations[0] = 1;

        for (int coin : coins)
            for (int s = coin; s <= sum; s++)
                combinations[s] += combinations[s - coin];

        return combinations[sum];
    }
}
