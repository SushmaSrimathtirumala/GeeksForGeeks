package Practice.DP.MinJumpsToEnd;

import java.util.Scanner;

/**
 * Created by gakshintala on 4/22/16.
 */
public class MinJumpsToEnd {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            if (len == 0) { // This is only for a test case having len = 0
                System.out.println(0);
                continue;
            }
            int[] arr = readArray(scn, len);
            System.out.println(minJumpsToEnd(arr));
        }
    }

    private static int[] readArray(Scanner scn, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }

    /**
     * This is comparatively better and cleaner approach
     */
    private static int minJumpsToEnd(int[] arr) {
        int len = arr.length;
        if (len == 0 || arr[0] == 0) {
            return -1;
        }

        int[] table = new int[len];
        table[0] = 0;

        // For every position, check from start left-to-right and set value based on the first encountered reachable
        for (int i = 1; i < len; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && table[j] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[j] + 1);
                    break; // At every position we shall be storing minimum steps,
                    // so table[j] itself is minimum to reach j, so you cannot get better than table[j]+1
                }
            }
        }
        return table[len - 1] == Integer.MAX_VALUE ? -1 : table[len - 1];
    }

}
