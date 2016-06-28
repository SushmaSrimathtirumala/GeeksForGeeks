package Regular.Arrays.SortTwoElementsSwapped;

import java.util.Arrays;

/**
 * Created by gakshintala on 4/14/16.
 */
public class SortTwoElementsSwapped {
    public static void main(String[] args) {
        int[] arr = {10, 30, 20, 40, 50, 60, 70};
        correctArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void correctArray(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;

                // Find the first encounter of smaller element than this towards left
                for (; j >= 0 && arr[j] > arr[i]; j--)
                    ;

                // Swap the number before the first smaller encounter
                swap(arr, i, j + 1);
                break;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
