package Regular.Arrays.SearchSortedRotated;

/**
 * Created by gakshintala on 6/13/16.
 */
public class SearchSortedRotated {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int key = 6;
        System.out.println(search(arr, key, 0, arr.length));
    }

    private static int search(int[] arr, int key, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        if (key > arr[left] && key < arr[mid])
            return search(arr, key, left, mid - 1);

        return search(arr, key, mid + 1, right);
    }
}
