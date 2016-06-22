package Practice.Arrays.RotateArray;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/22/16.
 */
public class RotateArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int rotateCount = scn.nextInt();

            int[] arr = new int[len];
            fillArray(arr, scn);

            rotateArray(arr, rotateCount);
            printArr(arr);
        }
    }

    private static void rotateArray(int[] arr, int rotateCount) {
        int len = arr.length;
        reverseArr(arr, 0, rotateCount - 1);
        reverseArr(arr, rotateCount, len - 1);
        reverseArr(arr, 0, len - 1);
    }

    private static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void printArr(int[] arr) {
        StringBuilder strb = new StringBuilder();
        for (int e : arr) {
            strb.append(e + " ");
        }
        System.out.println(strb);
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        if (pos1 == pos2) return;
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
