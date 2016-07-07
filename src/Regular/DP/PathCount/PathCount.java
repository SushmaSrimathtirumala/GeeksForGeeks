package Regular.DP.PathCount;

/**
 * Created by gakshintala on 7/2/16.
 */
public class PathCount {
    public static void main(String[] args) {
        System.out.println(pathCountForMatrixTopToBottom(3,3));
    }

    private static int pathCountForMatrixTopToBottom(int row, int col) {
        int[][] table = new int[row][col];
        for (int i = 1; i < row; i++) {
            table[i][0] = 1;
        }

        for (int j = 1; j < col; j++) {
            table[0][j] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1] + table[i - 1][j - 1];
            }
        }

        return table[row - 1][col - 1];
    }
}
