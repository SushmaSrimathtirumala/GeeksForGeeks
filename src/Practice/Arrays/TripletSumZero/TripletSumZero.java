package Practice.Arrays.TripletSumZero;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 3/3/17.
 */
public class TripletSumZero {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(tripletSumZero(arr, len) ? 1 : 0);
        }
    }

    private static boolean tripletSumZero(int[] arr, int len) {
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return true;
                }
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }


}
