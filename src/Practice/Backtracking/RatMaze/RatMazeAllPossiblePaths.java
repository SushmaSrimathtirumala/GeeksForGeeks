package Practice.Backtracking.RatMaze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is incomplete
public class RatMazeAllPossiblePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int dimen = scn.nextInt();
            int[][] maze = readMaze(dimen, scn);
            List<char[]> allPaths = new ArrayList<>();
            char[] path = new char[dimen * dimen];
            allPossiblePaths(maze, dimen, allPaths, path, 0, 0, 0);
        }
    }

    private static void allPossiblePaths(int[][] maze, int dimen, List<char[]> allPaths, char[] curPath, int pathIndex, int row, int col) {
        if (row == dimen && col == dimen) {
            allPaths.add(curPath);
            return;
        }
        if (isValidMove(maze, dimen, row, col)) {
            curPath[pathIndex] = 'D';
            allPossiblePaths(maze, dimen, allPaths, curPath, pathIndex + 1, row - 1, col);
            curPath[pathIndex] = 'U';
            allPossiblePaths(maze, dimen, allPaths, curPath, pathIndex + 1, row + 1, col);
            curPath[pathIndex] = 'R';
            allPossiblePaths(maze, dimen, allPaths, curPath, pathIndex + 1, row, col + 1);
            curPath[pathIndex] = 'L';
            allPossiblePaths(maze, dimen, allPaths, curPath, pathIndex + 1, row, col - 1);
        }
    }

    private static boolean isValidMove(int[][] maze, int dimen, int row, int col) {
        return (row >= 0 && row < dimen)
                && (col >= 0 && col < dimen)
                && (maze[row][col] != 0);
    }

    private static int[][] readMaze(int dimen, Scanner scn) {
        int[][] maze = new int[dimen + 1][dimen + 1];
        for (int i = 0; i < dimen; i++) {
            for (int j = 0; j < dimen; j++) {
                maze[i][j] = scn.nextInt();
            }
        }
        return maze;
    }
}
