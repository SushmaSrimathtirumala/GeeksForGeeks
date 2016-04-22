package Arrays.TrainglesPossible;

import java.util.Arrays;

/**
 * Created by gakshintala on 4/22/16.
 */
public class TrianglesPossible {
    public static void main(String[] args) {
        int arr[] = {10, 200, 22, 300, 101, 21, 100};
        System.out.println(trianglesPossible(arr));
    }

    private static int trianglesPossible(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int count = 0, j, k = 0;
        for (int i = 0; i < len - 2; i++) {
            k = i+2; // K is initialized only once for every loop.
            // We try with various j's and k takes-up from where it is left. So when we change j to a upper values, 
            // we check to see if that can extend the range to which k can go. We then calculate the possible 
            // triangle combos i, new j, till new k. Old i/j's get excluded in this combo, so always a new combo.
            for (j = i + 1; j < len - 1; j++) {
                for (; k < len && arr[i] + arr[j] > arr[k]; k++)
                    ; // All vals that satisfy this condition can be used along with i,j to form a traingle
                count += k - 1 - j; // k-1 coz last case where the loop broke should be discarded
            }
        }
        return count;
    }
}
