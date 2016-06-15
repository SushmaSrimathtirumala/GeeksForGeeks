package Regular.BackTracking;

import java.util.Arrays;

/**
 * Created by gakshintala on 4/7/16.
 */
public class RatMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        boolean[][] visited = new boolean[4][4];
        if (solveMaze(maze, 0, 0, visited)) {
            System.out.println("Rat reached the end! :)");
            for (boolean[] path : visited) {
                System.out.println(Arrays.toString(path));
            }
        } else {
            System.out.println("Rat can't be out :(");
        }
    }

    private static boolean solveMaze(int[][] maze, int i, int j, boolean[][] visited) {
        boolean isSolved = false;
        if (i == 3 && j == 3) return true; // Checking base case that Rat reached end
        if (isValidMove(i, j, maze)) {
            visited[i][j] = true;
            isSolved = solveMaze(maze, i + 1, j, visited) || solveMaze(maze, i, j + 1, visited);
            visited[i][j] = isSolved; // Backtracking, it will go to parent call and trigger the next recursive call 
            // after OR. If both are done, they shall go to their parent and so on
        }
        return isSolved;
    }

    private static boolean isValidMove(int i, int j, int[][] maze) {
        return i >= 0 && i < 4 && j >= 0 && j < 4 && maze[i][j] != 0;
    }

}
