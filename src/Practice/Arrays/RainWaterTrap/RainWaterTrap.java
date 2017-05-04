package Practice.Arrays.RainWaterTrap;

import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 8/15/17.
 */
public class RainWaterTrap {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = fillArray(len, scn);
            System.out.println(maxRainWaterTrap(arr, len));
        }
    }

    private static int maxRainWaterTrap(int[] arr, int len) {
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = arr[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int water = 0;
        for (int i = 0; i < len; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return water;
    }

    private static int[] fillArray(int len, Scanner scn) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
