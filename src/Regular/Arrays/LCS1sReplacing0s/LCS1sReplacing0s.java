package Regular.Arrays.LCS1sReplacing0s;

import java.util.Arrays;

/**
 * Created by gakshintala on 4/12/16.
 */
public class LCS1sReplacing0s {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(findMax1s(arr)));
    }

    private static int[] findMax1s(int[] arr) {
        int len = arr.length;
        int prev, currentStartingIndex;
        prev = currentStartingIndex = 0;
        int max = 0, maxIndex = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0 || i == len - 1) {
                int maxCurr = i - 1 - prev;
                if (maxCurr > max) {
                    max = maxCurr;
                    maxIndex = currentStartingIndex;
                }
                prev = currentStartingIndex;
                currentStartingIndex = i;
            }
        }
        return new int[]{maxIndex, max};
    }
}
