package Practice.DP.PalindromeMaker;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/20/16.
 */
public class PalindromeMaker {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            String str = scn.next();
            System.out.println(minCharsToInsertForPalindrome(str));
        }
    }

    private static int minCharsToInsertForPalindrome(String str) {
        int len = str.length();
        int[][] table = new int[len][len];

        for (int gap = 1; gap < len; gap++) {
            for (int i = 0, j = gap; j < len; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                } else {
                    table[i][j] = Math.min(table[i + 1][j], table[i][j - 1]) + 1;
                }
            }
        }
        return table[0][len - 1];
    }
}
