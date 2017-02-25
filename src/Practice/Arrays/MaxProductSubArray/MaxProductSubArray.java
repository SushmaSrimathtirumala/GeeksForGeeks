package Practice.Arrays.MaxProductSubArray;

import java.util.Scanner;

/**
 * Created by gakshintala on 7/3/16.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(maxProductSubArray(arr));
        }
    }

    private static int maxProductSubArray(int[] arr) {
        int curMax = 1, curMin = 1, maxSoFar = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                curMax *= arr[i];
                curMin = Math.min(curMin * arr[i], 1);
            } else if (arr[i] == 0) {
                curMax = curMin = 1;
            } else {
                int temp = curMax;
                curMax = Math.max(curMin * arr[i], 1);
                curMin = temp * arr[i];
            }
            maxSoFar = Math.max(maxSoFar, curMax); // we store result after every iteration,
            // as curMin and curMax keep shuffling as we encounter negative numbers
        }
        return maxSoFar;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
