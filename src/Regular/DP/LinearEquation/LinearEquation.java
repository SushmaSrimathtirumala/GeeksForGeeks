package Regular.DP.LinearEquation;

/**
 * Created by gakshintala on 6/10/16.
 */
public class LinearEquation {
    public static void main(String[] args) {
        int coeffs[] = {2, 2, 5};
        int rhs = 4;
        System.out.println(solutionCount(coeffs, rhs));
    }

    private static int solutionCount(int[] coeffs, int rhs) {
        int len = coeffs.length;
        int[] table = new int[rhs + 1];
        table[0] = 1; // if rhs=0, 1 solution i.e., all vals are 0s
        // Same as Coin Change problem
        // Per Coeff
        for (int coeff : coeffs) {
            // Looping through all possible vals till rhs
            for (int j = coeff; j <= rhs; j++) {
                table[j] += table[j - coeff];
            }
        }
        return table[rhs];
    }
}
