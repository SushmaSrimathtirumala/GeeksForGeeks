package Practice.Arrays.NonRepeatingNumber;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/22/16.
 */
public class NonRepeatingNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(nonRepeatingNumber(arr));
        }
    }

    private static int nonRepeatingNumber(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
