package Arrays.PairWithSum;

import static DsAndUtils.Utils.quickSort;

/**
 * Created by gakshintala on 6/10/16.
 */
public class PairWithSum {
    public static void main(String[] args) {
        int sum = 16;
        int[] arr = {1, 4, 45, 6, 10, -8};
        quickSort(arr);
        
        int left = 0;
        int right = arr.length-1;
        
        while(left < right) {
            int lrSum = arr[left] + arr[right];
            if(lrSum == sum) {
                System.out.println("("+arr[left]+","+arr[right]+")");
                break;
            } else if(lrSum < sum) left++;
            else right--;
        }
    }
}

