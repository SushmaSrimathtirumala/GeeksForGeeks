package Practice.Arrays.CountFrequencies;

import java.util.Scanner;

/**
 * Created by gakshintala on 7/6/16.
 */
public class CountFrequencies {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            printFrequency(arr);
            System.out.println();
        }
    }

    private static void printFrequency(int[] arr) {
        int len = arr.length;
        // This is necessary or the element which is equal to len will make problem while doing arr[i]%len
        for (int i = 0; i < len; i++) {
            arr[i]--;
        }
        for (int i = 0; i < len; i++) {
            // arr[i]%len because arr[i] might increase from it's actual value due to these increments, so we need to get actual value
            arr[arr[i] % len] += len;
        }
        for (int freq : arr) {
            System.out.print(freq / len + " ");
        }
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
