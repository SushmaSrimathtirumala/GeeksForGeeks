package Regular.DP.SubSetWithEqualSum;

/**
 * Created by gakshintala on 3/21/16.
 */
public class SubSetWithEqualSum {
    public static void main(String[] args) {
        int[] set = {1, 6, 11, 5};
        System.out.println(findMinDiff(set));
    }

    private static int findMinDiff(int[] set) {
        int sum = findSum(set);
        int len = set.length;
        boolean[][] table = new boolean[sum + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            table[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= len; j++) {
                table[i][j] = table[i][j - 1];
                if (set[j - 1] <= i) {
                    // Excluding or including
                    table[i][j] |= table[i - set[j - 1]][j];
                }
            }
        }

        return searchMinDiff(table, sum, len);
    }

    private static int searchMinDiff(boolean[][] table, int sum, int len) {
        for (int i = sum / 2; i >= 0; i--) {
            if (table[i][len]) {
                return sum - 2 * i; // Sum of one subset is i and other is sum-i, so its (Sum-i) - i 
            }
        }
        return Integer.MAX_VALUE; // no way this comes here
    }

    private static int findSum(int[] set) {
        int sum = 0;
        for (int i : set) {
            sum += i;
        }
        return sum;
    }
}
