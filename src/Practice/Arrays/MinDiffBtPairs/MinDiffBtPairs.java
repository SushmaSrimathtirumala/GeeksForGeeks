package Practice.Arrays.MinDiffBtPairs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 30/01/17.
 */
public class MinDiffBtPairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(minDiffBtPairs(arr));
        }
    }

    private static int minDiffBtPairs(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            diff = Math.min(arr[i + 1] - arr[i], diff);
        }
        return diff;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
