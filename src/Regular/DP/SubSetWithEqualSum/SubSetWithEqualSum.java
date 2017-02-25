package Regular.DP.SubSetWithEqualSum;

import java.util.Arrays;

/**
 * Created by gakshintala on 3/21/16.
 */
public class SubSetWithEqualSum {
    public static void main(String[] args) {
        int[] set = {1, 6, 11, 5};
        System.out.println(isSubSetWithEqualSumExists(set));
    }

    private static boolean isSubSetWithEqualSumExists(int[] set) {
        int sum = Arrays.stream(set).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int len = set.length;
        boolean[][] table = new boolean[sum + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            table[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            table[i][0] = false;
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

        return table[sum / 2][len];
    }

}
