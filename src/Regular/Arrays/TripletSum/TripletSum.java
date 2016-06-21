package Regular.Arrays.TripletSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gakshintala on 6/16/16.
 */
public class TripletSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int sum = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            printTriplets(arr, sum);
            System.out.println();
        }
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    private static void printTriplets(int[] a, int sum) {
        int len = a.length;
        Arrays.sort(a);
        // <len-2 coz inner loop takes care of testing with rest two len-2, len-1
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1; // We carry from i+1 because, the previous numbers are already tested with i+1 th number 
            // and no point in testing them again.
            int r = len - 1;
            while (l < r) {
                int curSum = a[i] + a[l] + a[r];
                if (curSum == sum) {
                    //System.out.println("(" + a[i] + "," + a[l] + "," + a[r] + ")");
                    System.out.print(1);
                    return;
                } else if (curSum < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        System.out.print(0);
    }
}
