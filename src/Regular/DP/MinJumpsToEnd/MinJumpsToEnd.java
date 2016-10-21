package Regular.DP.MinJumpsToEnd;

import java.util.Arrays;

/**
 * Created by gakshintala on 4/22/16.
 */
public class MinJumpsToEnd {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 1, 0, 9};
        System.out.println(minJumpsToEnd(arr));
        System.out.println(minJumpsToEnd2(arr));
    }

    private static int minJumpsToEnd(int[] arr) {
        int len = arr.length;
        int[] table = new int[len];
        table[0] = 0;

        for (int i = 1; i < len; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        // For every position, calculate for all the reachable positions on right side
        for (int i = 0; i < len; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + arr[i]; j++) {
                // If reachable position exceeds the End, consider it for the end.
                int k = (j >= len - 1) ? len - 1 : j;
                table[k] = Math.min(table[k], table[i] + 1);
            }
        }
        System.out.println(Arrays.toString(table));
        return table[len - 1];
    }

    /**
     * This is comparatively better and cleaner approach
     */
    private static int minJumpsToEnd2(int[] arr) {
        int len = arr.length;
        if (len == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        int[] table = new int[len];
        table[0] = 0;

        // For every position, check from start left-to-right and set value based on the first encountered reachable
        for (int i = 1; i < len; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && table[j] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[j] + 1);
                    break; // because table[j] itself is minimum to reach j, so you cannot get better than table[j]+1
                }
            }
        }
        System.out.println(Arrays.toString(table));
        return table[len - 1];
    }
}
