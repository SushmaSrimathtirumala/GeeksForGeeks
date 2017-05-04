package Practice.Greedy.MinSumWithDigitsOfArray;

import java.util.Arrays;
import java.util.Scanner;

public class MinSumWithDigitsOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            int[] arr = readArray(scn, len);
            printMinSumWithDigitsOfArray(arr);
        }
    }

    private static void printMinSumWithDigitsOfArray(int[] arr) {
        Arrays.sort(arr);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }
        System.out.println(num1 + num2);
    }

    private static int[] readArray(Scanner scn, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
