package Practice.DP.MatrixPathCount;

import java.util.Scanner;

/**
 * Created by gakshintala on 7/2/16.
 */
public class MatrixPathCount {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int row = scn.nextInt();
            int col = scn.nextInt();
            System.out.println(pathCountForMatrixTopToBottom(row, col));
        }
    }

    private static int pathCountForMatrixTopToBottom(int row, int col) {
        int[][] table = new int[row][col];
        for (int i = 0; i < row; i++) {
            table[i][0] = 1;
        }

        for (int j = 0; j < col; j++) {
            table[0][j] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        return table[row - 1][col - 1];
    }
}
