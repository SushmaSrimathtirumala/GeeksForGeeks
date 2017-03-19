package Regular.DP.CoinCombinationsForSum;

/**
 * Created by gakshintala on 4/22/16.
 */
public class CoinCombinationsForSum {
    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        System.out.println(coinCombinationsForSum(coins, 4));
    }

    private static int coinCombinationsForSum(int[] coins, int sum) {
        int[] table = new int[sum + 1];
        table[0] = 1;

        // For every coin, loop through all the sums
        for (int coin : coins) {
            // If you include this coin, minimum sum u make starts from that coin
            for (int j = coin; j <= sum; j++) {
                table[j] += table[j - coin]; // including the coin
            }
        }
        return table[sum];
    }
}
