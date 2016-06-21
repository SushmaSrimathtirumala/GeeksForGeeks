package Regular.Arrays.BeforeSmallAfterGreat;

/**
 * Created by gakshintala on 6/13/16.
 */
public class BeforeSmallAfterGreat {
    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(findPos(arr));
    }

    private static int findPos(int[] arr) {
        int len = arr.length;
        int[] leftMaxArr = new int[len + 1];
        leftMaxArr[0] = Integer.MIN_VALUE;
        // Min of numbers before i, so we compare with i-1.
        for (int i = 1; i <= len; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i - 1], arr[i - 1]);
        }

        int rightMin = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            // We compare with right min after the current i. So if condition is placed before setting new rightMin.
            if (arr[i] > leftMaxArr[i] && arr[i] < rightMin) {
                return i; // Returns position
            }
            rightMin = Math.min(rightMin, arr[i]);
        }
        return -1;
    }
}
