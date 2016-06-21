package Practice.TwiceMinGTMax;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/20/16.
 */
public class TwiceMinGTMax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(minElementsToRemove(arr));
        }
    }

    /*private static int minElementsToRemove(int[] arr) {
        int len = arr.length;
        int[][] table = new int[len][len];
        for (int gap = 1; gap < len; gap++) {
            for (int i = 0, j = gap; j < len; i++, j++) {
                int[] minMax = findMinMax(arr, i, j);
                int min = minMax[0];
                int max = minMax[1];

                if (2 * min > max) {
                    table[i][j] = 0; // 0 because at every iteration, we are checking max min for entire array. so 
                    // nothing to depend on the subset.
                } else {
                    table[i][j] = Math.min(table[i + 1][j], table[i][j - 1]) + 1;
                }
            }
        }
        return table[0][len-1];
    }*/

    private static int minElementsToRemove(int[] arr) {
        int len = arr.length;
        int long_start = -1, long_end = 0;
        for (int start = 0; start < len; start++) {
            int min = arr[start], max = arr[start];
            for (int end = start + 1; end < len; end++) {
                min = Math.min(min, arr[end]);
                max = Math.max(max, arr[end]);
                if (2 * min <= max) break;

                if (end - start > long_end - long_start || long_start == -1) {
                    long_start = start;
                    long_end = end;
                }
            }
        }
        if (long_start == -1) return len;
        return len - (long_end - long_start + 1);
    }

    /*private static int[] findMinMax(int[] arr, int i, int j) {
        int[] minMax = new int[2];
        minMax[0] = minMax[1] = arr[i];
        for (int e : Arrays.copyOfRange(arr,i+1,j+1)) {
            minMax[0] = Math.min(minMax[0], e);
            minMax[1] = Math.max(minMax[1], e);
        }
        return minMax;
    }*/

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
