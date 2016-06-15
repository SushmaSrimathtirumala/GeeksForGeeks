package Regular.BackTracking;

import java.util.Arrays;

/**
 * Created by Go on 9-4-16.
 */
public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        int[] begin = {0, 0};
        if (solveSudoku(grid, begin)) {
            for (int[] arr : grid) {
                System.out.println(Arrays.toString(arr));
            }
        } else {
            System.out.println("Solution does not exist");
        }
    }

    private static boolean solveSudoku(int[][] grid, int[] lastFilled) {
        int[] unfilled = findNextUnfilled(grid, lastFilled);
        if (unfilled[0] == -1 && unfilled[1] == -1) return true; // Base Condition, no unfilled items
        for (int val = 1; val <= 9; val++) { // For loop, whenever we backtrack, check for next case
            if (isSafe(val, grid, unfilled)) { // Is next step valid
                grid[unfilled[0]][unfilled[1]] = val;
                // Recursion
                if (!solveSudoku(grid, unfilled)) {
                    // Backtracking
                    grid[unfilled[0]][unfilled[1]] = 0;
                } else {
                    return true;
                }
            }
        }
        return false; // Tried everything and failed.
    }

    private static boolean isSafe(int val, int[][] grid, int[] unfilled) {
        return isNotInRow(val, grid, unfilled) && isNotInColumn(val, grid, unfilled) && isNotInBox(val, grid, unfilled);
    }

    private static boolean isNotInRow(int val, int[][] grid, int[] unfilled) {
        for (int j = 0; j < 9; j++) {
            if (j == unfilled[1]) continue;
            if (grid[unfilled[0]][j] == val)
                return false;
        }
        return true;
    }

    private static boolean isNotInColumn(int val, int[][] grid, int[] unfilled) {
        for (int i = 0; i < 9; i++) {
            if (i == unfilled[0]) continue;
            if (grid[i][unfilled[1]] == val)
                return false;
        }
        return true;
    }

    private static boolean isNotInBox(int val, int[][] grid, int[] unfilled) {
        int xBox = unfilled[0] / 3;
        int yBox = unfilled[1] / 3;
        for (int i = xBox * 3; i <= xBox + 3; i++) {
            for (int j = yBox * 3; j < yBox + 3; j++) {
                if (i == unfilled[0] && j == unfilled[1]) continue;
                if (grid[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    private static int[] findNextUnfilled(int[][] grid, int[] lastFilled) {
        int[] unfilled = new int[2];
        unfilled[0] = -1;
        unfilled[1] = -1;

        for (int j = lastFilled[1]; j < 9; j++) {
            if (grid[lastFilled[0]][j] == 0) {
                unfilled[0] = lastFilled[0];
                unfilled[1] = j;
                return unfilled;
            }
        }
        for (int i = lastFilled[0] + 1; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    unfilled[0] = i;
                    unfilled[1] = j;
                    return unfilled;
                }
            }
        }
        return unfilled;
    }
}
