package Practice.DP.WaysToFillTiles;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/20/16.
 */
public class WaysToFillTiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int gridDim = scn.nextInt();
            System.out.println(numberOfWaysToFillGrid(gridDim));
        }
    }

    private static long numberOfWaysToFillGrid(int gridDim) {
        long[] table = new long[gridDim + 1];
        table[0] = 0;
        for (int i = 1; i <= gridDim; i++) {
            if (i < 4) {
                table[i] = 1;
            } else if (i == 4) {
                table[i] = 2; // Either vertically or horizontally
            } else {
                // Fill Horizontal, u r left with i-1 grid to fill
                // Fill Vertical, u r left with i-4 grid to fill, cause the grids parallel to vertically filled one
                // can only be filled in one way (imagine)
                table[i] = table[i - 1] + table[i - 4];
            }
        }
        return table[gridDim];
    }
}
