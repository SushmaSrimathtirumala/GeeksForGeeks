package Regular.DP.IncreasingSubSequence;

import java.util.Arrays;

/**
 * Created by gakshintala on 6/11/16.
 */
public class IncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(longestIncreasingSubSequence(arr));
    }

    private static int longestIncreasingSubSequence(int[] arr) {
        int len = arr.length;
        int[] table = new int[len];
        table[0] = 1;
        for(int i=1; i< len; i++) {
            table[i] = 1;
            for(int j=0; j< i; j++) {
                // If you find an element less than the current element we are checking for, see if the increasing 
                // subsequence it contributes is max or not
                if(arr[j] < arr[i]) {
                    table[i] = Math.max(table[i], table[j]+1);
                }
            }
        }
        return Arrays.stream(table).max().getAsInt();
    }
}
