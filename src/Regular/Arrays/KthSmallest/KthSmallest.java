package Regular.Arrays.KthSmallest;

import static Regular.DsAndUtils.Utils.swap;

/**
 * Created by gakshintala on 6/11/16.
 */
public class KthSmallest {
    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.println(quickSelect(arr, 0, arr.length - 1, k));
    }
    
    private static int quickSelect(int[] arr, int l, int r, int k) {
        if (k >= 0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
            // pos-l coz if we move to right, k varies
            if(pos-l == k-1) {
                return arr[pos];
            } 
            if(pos > k-1) {
                // we can consider from pos-1, as the current element in pos is found its fixed position and cannot 
                // be the kth element. 
                return quickSelect(arr, l, pos-1, k);
            }
            
            // K varies if we move to right relatively. k-((pos+1)-l)), +1 because we are considering from pos+1
            return quickSelect(arr, pos+1, r, k-((pos+1)-l));
        }
        return -1;
    }

    // Alternate way to partition, more elegant
    private static int partition(int[] arr, int l, int r) {
        int i = l;
        // Shifting all the lesser elements to left
        for (int j = l; j < r; j++) {
            if (arr[j] <= arr[r]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
