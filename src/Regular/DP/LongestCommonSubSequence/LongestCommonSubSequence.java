package Regular.DP.LongestCommonSubSequence;

/**
 * Created by gakshintala on 6/11/16.
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";

        System.out.println(longestCommonSubSequence(a, b));
    }

    private static int longestCommonSubSequence(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] table = new int[aLen + 1][bLen + 1];

        for (int i = 0; i <= aLen; i++) {
            for (int j = 0; j <= bLen; j++) {
                // This is required to avoid ArrayIndexOutOfBoundsException, in line 26. Otherwise, we have to check 
                // if i-1 > 0 before using that value.
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else {
                    // if char matches
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    } else {
                        // max of char not present in a, char not present in b
                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                    }
                }
            }
        }
        return table[aLen][bLen];
    }
}
