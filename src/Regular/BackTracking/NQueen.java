package Regular.BackTracking;

import java.util.Arrays;

/**
 * Created by Go on 9-4-16.
 */
public class NQueen {
    public static void main(String[] args) {
        int board[][] = { {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        if(solveNQueen(board, 0)){
            for(int[] arr: board){
                System.out.println(Arrays.toString(arr));
            }
        }
        else {
            System.out.println("Solution Doesn't exist");
        }
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if(col >= 4)
            return true;
        for(int i=0;i<4;i++) {
            if(isSafe(board,i, col)) {
                board[i][col]=1;
                // Regular.BackTracking
                if(!solveNQueen(board,col+1)) {
                    board[i][col] = 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j) {
        return isNotInRow(board,i,j) && isNotInColumn(board,i,j) && isNotInDiagnalBehind(board,i,j);
    }

    private static boolean isNotInRow(int[][] board, int row, int col) {
        for(int j=0;j<4;j++){
            if(j==col) continue;
            if(board[row][j]==1)
                return false;
        }
        return true;
    }

    private static boolean isNotInColumn(int[][] board, int row, int col) {
        for(int i=0;i<4;i++){
            if(i==row) continue;
            if(board[i][col]==1)
                return false;
        }
        return true;
    }

    private static boolean isNotInDiagnalBehind(int[][] board, int row, int col) {
        for(int i=row,j=col; i>=0 && j>=0; i--,j--) {
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
}
