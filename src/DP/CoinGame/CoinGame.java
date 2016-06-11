package DP.CoinGame;

/**
 * Created by gakshintala on 6/10/16.
 */
public class CoinGame {
    public static void main(String[] args) {
        int arr[] = {8, 15, 3, 7};
        System.out.println(maxValueInGame(arr));
    }

    private static int maxValueInGame(int[] arr) {
        int len = arr.length;
        // Dealing in Tuples. This table is populated only half, tending towards top right
        int[][] table = new int[len][len];
        // Although we start with gap 0, cases are handled accordingly as we are checking bounds. It needs minimum of
        // 3 coins for a game or it is just maximum of both.
        for (int gap = 0; gap < len; gap++) {
            for (int i = 0, j = gap; j < len; i++, j++) {
                // Checking if bounds are valid, if valid return table results or 0, which eventually goes into table
                int x = (i + 2 < j) ? table[i + 2][j] : 0;
                int y = (i + 1 < j - 1) ? table[i + 1][j - 1] : 0;
                int z = (i < j - 2) ? table[i][j - 2] : 0;

                // If you pick ith coin, the other users picks a coin making your next pick be minimum of two 
                // possibilities i.e., if he picks i+1, we are left with i+2, j. If he picks j, we are left with i+1,
                // j-1. Similar, if we pick jth coin.
                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return table[0][len - 1];
    }
}
