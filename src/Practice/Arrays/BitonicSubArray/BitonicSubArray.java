package Practice.Arrays.BitonicSubArray;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/15/16.
 */
public class BitonicSubArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(bitonicSubArray(arr));
        }
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    private static int bitonicSubArray(int[] arr) {
        int len = arr.length;
        int[] inc = new int[len];
        int[] dec = new int[len];
        inc[0] = dec[len - 1] = 1; // By default every element is a sequence with length 1
        // Calculate consecutive increment and decrement sequences
        for (int i = 1; i < len; i++) {
            inc[i] = (arr[i] > arr[i - 1]) ? inc[i - 1] + 1 : 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            dec[i] = (arr[i] > arr[i + 1]) ? dec[i + 1] + 1 : 1;
        }

        int max = inc[0] + dec[0] - 1; // -1 cause current element is included twice.
        for (int i = 1; i < len; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }
        return max;
    }
}
