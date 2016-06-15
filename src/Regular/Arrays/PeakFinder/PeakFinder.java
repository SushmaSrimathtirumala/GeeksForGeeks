package Regular.Arrays.PeakFinder;

/**
 * Created by gakshintala on 6/13/16.
 */
public class PeakFinder {
    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};
        System.out.println(findPeak(arr, 0, arr.length-1, arr.length-1));
    }

    private static int findPeak(int[] arr, int left, int right, int len) {
        int mid = (left+right)/2;
        // In cases where array in strictly increasing or decreasing these || come into action
        if((mid==0 || arr[mid] >= arr[mid-1]) && (mid==len-1 && arr[mid] >= arr[mid+1])) {
            return mid;
        }
        
        // Since this indicates positive slope, Travel towards the peak i.e right side
        if(arr[mid] > arr[mid+1]) {
            return findPeak(arr, mid+1, right, len);
        }
        
        return findPeak(arr, left, mid-1, len);
    }
}
