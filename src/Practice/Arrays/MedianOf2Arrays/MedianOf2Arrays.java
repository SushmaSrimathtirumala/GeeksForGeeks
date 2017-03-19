package Practice.Arrays.MedianOf2Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gakshintala on 7/2/16.
 */
public class MedianOf2Arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr1 = new int[len];
            fillArray(arr1, scn);
            int[] arr2 = new int[len];
            fillArray(arr2, scn);
            System.out.println(medianOf2Arrays(arr1, arr2));
        }
    }

    private static int medianOf2Arrays(int[] arr1, int[] arr2) {
        int len = arr1.length;
        if (len <= 0) {
            return -1;
        }
        if (len == 1) {
            return (arr1[0] + arr2[0]) / 2;
        }
        if (len == 2) {
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
        }

        int m1 = medianOfArray(arr1);
        int m2 = medianOfArray(arr2);

        if (m1 == m2) {
            return m1;
        }

        if (m1 > m2) { // If we merge, Median is dragged towards left for arr1 and right for arr2
            if (len % 2 == 0) {
                return medianOf2Arrays(Arrays.copyOfRange(arr1, 0, len / 2 + 1), Arrays.copyOfRange(arr2, len / 2 - 1, len));
            }
            return medianOf2Arrays(Arrays.copyOfRange(arr1, 0, len / 2), Arrays.copyOfRange(arr2, len / 2, len));
        } else {
            if (len % 2 == 0) {
                return medianOf2Arrays(Arrays.copyOfRange(arr2, 0, len / 2 + 1), Arrays.copyOfRange(arr1, len / 2 - 1, len));
            }
            return medianOf2Arrays(Arrays.copyOfRange(arr2, 0, len / 2), Arrays.copyOfRange(arr1, len / 2, len));
        }

    }

    private static int medianOfArray(int[] arr) {
        int len = arr.length;
        int mid = len / 2;
        if (len % 2 == 1) {
            return arr[mid];
        } else {
            return (arr[mid] + arr[mid - 1]) / 2;
        }
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
