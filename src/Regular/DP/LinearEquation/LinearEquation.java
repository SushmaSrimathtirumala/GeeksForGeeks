package Regular.DP.LinearEquation;

/**
 * Created by gakshintala on 6/10/16.
 */
public class LinearEquation {
    public static void main(String[] args) {
        int coeff[] = {2, 2, 5};
        int rhs = 4;
        System.out.println(solutionCount(coeff, rhs));
    }

    private static int solutionCount(int[] coeff, int rhs) {
        int len = coeff.length;
        int[] table = new int[rhs + 1];
        table[0] = 1; // if rhs=1, 1 solution i.e., all vals are 0s
        // Same as Coin Change problem
        // Per Coeff
        for (int i = 0; i < len; i++) {
            // Looping through all possible vals till rhs
            for (int j = coeff[i]; j <= rhs; j++) {
                table[j] += table[j - coeff[i]];
            }
        }
        return table[rhs];
    }
}
