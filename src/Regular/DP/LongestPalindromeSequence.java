package Regular.DP;

/**
 * Created by gakshintala on 4/20/16.
 */
public class LongestPalindromeSequence {
    public static void main(String[] args) {
        char seq[] = "GEEKS FOR GEEKS".toCharArray();
        System.out.println(longestPalindromeSequence(seq));
    }

    private static int longestPalindromeSequence(char[] seq) {
        int n = seq.length;
        int[][] table = new int[n][n];
        // Fill the diagonal in the matrix, only upper half shall be used.
        for (int i = 0; i < n; i++) {
            table[i][i] = 1;
        }
        // Calculating through increasing windows
        for (int gap = 2; gap <= n; gap++) {
            for (int i = 0, j = gap + i - 1; j < n; i++, j++) {
                // If gap 2, then palindrome length 2
                if (seq[i] == seq[j] && gap == 2) {
                    table[i][j] = 2;
                } else if (seq[i] == seq[j]) {
                    table[i][j] = table[i + 1][j - 1] + 2;
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
                }
            }
        }
        // Matrix keep building top-right direction and result stored in 0,n-1
        return table[0][n - 1];
    }
}
