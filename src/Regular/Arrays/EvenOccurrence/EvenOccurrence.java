package Regular.Arrays.EvenOccurrence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gakshintala on 6/27/16.
 */
public class EvenOccurrence {
    public static void main(String[] args) {
        int arr[] = { 9, 12, 23, 10, 12, 12, 15, 23, 14, 12, 15 };
        System.out.println(evenOccuranceNum(arr));
    }

    private static List<Integer> evenOccuranceNum(int[] arr) {
        int len = arr.length;
        int checker = 0;
        
        // Prepare bit map for even odd occurrences. Even shall have 0 and odd have 1. 
        for(int i=0; i<len; i++) {
            checker ^= (1 << arr[i]);
        }
        
        List<Integer> evenOccurances = new ArrayList<>();
        
        // Traverse again to check which number has 0 and which has 1.
        for(int i=0; i<len-1; i++) {
            if((checker & (1 << arr[i])) == 0) {
                evenOccurances.add(arr[i]);
            }
            // Setting it to 1 to avoid duplicates
            checker |= (1 << arr[i]);
        }
        return evenOccurances;
    }
}
