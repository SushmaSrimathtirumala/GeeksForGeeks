package Regular.Arrays.PeakFinder;

/**
 * Created by gakshintala on 6/13/16.
 */
public class PeakFinder {
    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};
        System.out.println(findPeak(arr, 0, arr.length - 1));
    }

    private static int findPeak(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        // Since we are always travelling towards positive slope, if the element is greater than both neighbours (if 
        // the neighbours exists and so is the check with ||), then it's the peak. 
        if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
            return mid;
        }

        // Since this indicates positive slope, Travel towards the peak i.e right side
        if (arr[mid] > arr[mid + 1]) {
            return findPeak(arr, mid + 1, right);
        }

        return findPeak(arr, left, mid - 1);
    }
}
