package Practice.Arrays.MajorityElement;

import java.util.Scanner;

/**
 * Created by gakshintala on 7/3/16.
 */
public class MajorityElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            printMajorityElement(arr);
        }
    }

    private static void printMajorityElement(int[] arr) {
        int count = 1, curEle = arr[0];
        // Only Majority element can have non-zero count.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curEle) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                curEle = arr[i];
                count = 1;
            }
        }
        if (isElementMajority(curEle, arr)) {
            System.out.println(curEle);
        } else {
            System.out.println("NO Majority Element");
        }
    }

    private static boolean isElementMajority(int curEle, int[] arr) {
        int count = 0;
        for (int ele : arr) {
            if (ele == curEle) {
                count++;
            }
        }
        return count > (arr.length / 2);
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
