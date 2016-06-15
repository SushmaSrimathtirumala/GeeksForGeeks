package Regular.Arrays.SubsetMaxSum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by gakshintala on 2/25/16.
 */
public class SubsetMaxSum {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        final List<Integer> arrList = new ArrayList<>();
        IntStream.of(arr).forEach(e -> arrList.add(e));
        System.out.println(findMaximumSubarrayContiguous(arrList).maxSum + " " + findMaximumSubarrayNonContiguous
                (arrList));

    }

    /*public static Subarray findMaximumSubarray2(List<Integer> A) {
        Subarray range = new Subarray(0, 0, 0);
        int startIndex = 0, sum = 0; 
        int maxSum = 0, minSum = 0;
        for (int i = 0; i < A.size(); ++i) {
            sum += A.get(i);
            if (sum < minSum) {
                minSum = sum;
                startIndex = i + 1;
            }
            if (sum - minSum > maxSum) { // Nullifying the Negative portion of sum by adding it back to sum
                maxSum = sum - minSum;
                range = new Subarray(startIndex + 1, i + 1, maxSum);
            }
        }
        return range;
    }*/

    private static Subarray findMaximumSubarrayContiguous(List<Integer> arr) {
        Subarray subarray = new Subarray(0, 0, 0);
        int sum = 0, startIndex = 0, maxSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (sum < 0) { // Nullifying the Negative portion of sum by making it 0
                sum = 0;
                startIndex = i + 1;
            } else if (sum > maxSum) {
                maxSum = sum;
                subarray = new Subarray(startIndex + 1, i + 1, maxSum);
            }
        }
        if (maxSum == 0) subarray.maxSum = getMaxInArray(arr);
        return subarray;
    }

    private static int findMaximumSubarrayNonContiguous(List<Integer> arr) {
        int sum = arr.stream().filter(e -> e > 0).mapToInt(e -> e).sum();
        return (sum!=0)? sum: arr.stream().mapToInt(e->e).max().getAsInt();
    }

    private static int getMaxInArray(List<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            if (val > max) max = val;
        }

        return max;
    }
}

class Subarray {
    public int start;
    public int end;
    public int maxSum;

    public Subarray(int start, int end, int maxSum) {
        this.start = start;
        this.end = end;
        this.maxSum = maxSum;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + "): " + maxSum;
    }
}
