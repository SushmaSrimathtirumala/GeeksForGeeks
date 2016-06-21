package Regular.Arrays.DoubletSum;

import java.util.Arrays;

/**
 * Created by gakshintala on 6/16/16.
 */
public class DoubletSum {
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A, n);
    }

    private static void printpairs(int[] a, int sum) {
        Arrays.sort(a);
        int len = a.length;
        int l = 0, r = len - 1;
        while (l < r) {
            if (a[l] + a[r] == sum) {
                System.out.println("(" + a[l] + "," + a[r] + ")");
                return;
            } else if (a[l] + a[r] < sum) {
                l++;
            } else {
                r--;
            }
        }
    }
}
