package Practice.SortAndSearch.SearchInSortedRotated;

import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 22/02/17.
 */
public class SearchInSortedRotated {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = fillArray(len, scn);
            int numToSearch = scn.nextInt();
            System.out.println(searchInRotatedArray(arr, numToSearch, 0, len - 1));
        }
    }

    private static int searchInRotatedArray(int[] arr, int numToSearch, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == numToSearch) {
            return mid;
        }
        if (arr[left] <= arr[mid]) { // if left half is sorted
            // We check for sorted side because, we can rely on the below condition only if that part of array is sorted.
            if (numToSearch >= arr[left] && numToSearch <= arr[mid]) {
                return searchInRotatedArray(arr, numToSearch, left, mid - 1);
            }
            return searchInRotatedArray(arr, numToSearch, mid + 1, right);
        }
        // if left not sorted than right is obviously sorted.
        if (numToSearch >= arr[mid] && numToSearch <= arr[right]) {
            return searchInRotatedArray(arr, numToSearch, mid + 1, right);
        }
        return searchInRotatedArray(arr, numToSearch, left, mid - 1);
    }

    private static int[] fillArray(int len, Scanner scn) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }

}
