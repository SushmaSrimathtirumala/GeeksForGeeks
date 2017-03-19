package Regular.Arrays.NonDivisibleSubset;

/**
 * Created by Gopala Akshintala on 3/13/17.
 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 1};
        int k = 3;
        System.out.println(maxLenOfNonDivisibleSubset(arr, k));
    }

    private static int maxLenOfNonDivisibleSubset(int[] arr, int k) {
        int len = arr.length;
        int[] reminderArr = new int[len];

        for (int i = 0; i < len; i++) {
            reminderArr[arr[i] % k]++;
        }

        if (k % 2 == 0) {
            reminderArr[k / 2] = Math.min(reminderArr[k / 2], 1);
        }

        int result = Math.min(reminderArr[0], 1);
        for (int i = 1; i <= k / 2; i++) {
            result += Math.max(reminderArr[i], reminderArr[k - i]); // we can either include these or those
        }
        return result;
    }
}
