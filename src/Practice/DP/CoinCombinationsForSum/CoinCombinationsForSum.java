package Practice.DP.CoinCombinationsForSum;

import java.util.Scanner;

/**
 * Created by gakshintala on 4/22/16.
 */
public class CoinCombinationsForSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            int[] arr = readArray(scn, len);
            int sum = scn.nextInt();
            System.out.println(maximumPossibleCombinations(arr, sum));
        }
    }

    private static int maximumPossibleCombinations(int[] coins, int sum) {
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

    private static int[] readArray(Scanner scn, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
