package dynamicprogramming;

public class SumCoinCombination {

    public int combinations(int sum, int[] coins) {
        //init
        int[] combinations = new int[sum + 1];
        combinations[0] = 1;

        //compute
        for (int coin : coins) {
            for (int amount = coin; amount <= sum; amount ++) {
                combinations[amount] += combinations [amount - coin];
            }
        }

        //return solution
        return combinations[sum];
    }

    public static void main(String[] args) {
        int sum = 12;
        int[] coins = new int[] {1,2,5};

        SumCoinCombination sumCoins = new SumCoinCombination();
        System.out.println(sumCoins.combinations(sum, coins));
    }
}
