package Regular.DP.CoinCombination;

/**
 * Created by gakshintala on 4/22/16.
 */
public class CoinCombination {
    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        System.out.println(coinCombination(coins, 4));
    }

    private static int coinCombination(int[] coins, int sum) {
        int[] table = new int[sum + 1];
        table[0] = 1;
        int coinLen = coins.length;

        // For every coin, loop through all the sums
        for (int i = 0; i < coinLen; i++) {
            // If you include this coin, minimum sum u make starts from coins[i]
            for (int j = coins[i]; j <= sum; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        return table[sum];
    }
}
