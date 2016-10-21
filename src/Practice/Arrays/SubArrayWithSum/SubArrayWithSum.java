package Practice.Arrays.SubArrayWithSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by gakshintala on 6/29/16.
 */
public class SubArrayWithSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int sum = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            printIndicesOfSubArray(arr, sum);
            printIndicesOfSubArrayWithNegativeNums(arr, sum);
        }
    }

    private static void printIndicesOfSubArray(int[] arr, int sum) {
        int curSum = arr[0], start = 0, len = arr.length;
        boolean foundFlag = false;
        // i <= len because, curSum made by last digit also need to go through trimming. So iterate one extra time 
        // after all the digits are over.
        for (int i = 1; i <= len; i++) {
            // Trim from start till curSum falls below sum. start < i - 1 is to avoid trimming from empty list
            while (curSum > sum && start < i - 1) {
                curSum -= arr[start];
                start++;
            }
            if (curSum == sum) {
                foundFlag = true;
                System.out.println(start + 1 + " " + i); // Print 1-based indices
                break;
            }
            // Just to avoid this in the last iteration.
            if (i != len) {
                curSum += arr[i];
            }
        }
        if (!foundFlag) {
            System.out.println(-1);
        }
    }

    private static void printIndicesOfSubArrayWithNegativeNums(int[] arr, int sum) {
        int curSum = arr[0], start = 0, len = arr.length;
        boolean foundFlag = false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(curSum, 0);
        // No need for i<=len coz, last digit case shall be checked in the last iteration itself
        for (int i = 1; i < len; i++) {
            curSum += arr[i];
            if (map.get(curSum - sum) != null) {
                // Found subArray from 0 to some point which can make curSum - sum, so subarray from that point to current 
                // point shall make sum.
                foundFlag = true;
                System.out.println((map.get(curSum - sum) + 2) + " " + i+1); // Print 1-based indices
                break;
            }
            map.put(curSum, i);
        }
        if (!foundFlag) {
            System.out.println(-1);
        }
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}