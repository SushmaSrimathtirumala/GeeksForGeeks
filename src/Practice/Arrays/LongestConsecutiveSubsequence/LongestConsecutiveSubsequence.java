package Practice.Arrays.LongestConsecutiveSubsequence;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gakshintala on 6/20/16.
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(longestConsecutiveSubsequenceOptimistic(arr));
        }
    }

    private static int longestConsecutiveSubsequenceOptimistic(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int maxSubsequenceLen = 0;
        for (int ele : arr) {
            if (!set.contains(ele - 1)) {
                int j = ele;
                while (set.contains(j)) {
                    j++;
                }
                maxSubsequenceLen = Math.max(maxSubsequenceLen, j - ele);
            }
        }
        return maxSubsequenceLen;
    }

    private static int longestConsecutiveSubsequence(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int count = 1;
            for (int j = i; j > 0; j--) {
                if (arr[j] == arr[j - 1] + 1) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
