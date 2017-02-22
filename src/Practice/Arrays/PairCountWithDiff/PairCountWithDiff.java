package Practice.Arrays.PairCountWithDiff;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gakshintala on 7/3/16.
 */
public class PairCountWithDiff {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int diffReq = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(pairCountWithDiff(arr, diffReq));
        }
    }

    private static int pairCountWithDiff(int[] arr, int diffReq) {
        Arrays.sort(arr);
        int l = 0, r = 1, count = 0;
        int len = arr.length;
        while (r < len) {
            int diff = arr[r] - arr[l];
            if (diff == diffReq) {
                // Uncomment below and comment rest in this block, if distinct pairs are required. Also need a bit 
                // more work to check if next combo after increment is same or different
                /*count++
                r++;l++; */

                int tempL = l, tempR = r;
                l++;
                r++;
                // If we have duplicates
                while (arr[l - 1] == arr[l]) {
                    l++;
                }
                while (r < len && arr[r - 1] == arr[r]) {
                    r++;
                }
                count += ((l - tempL) * (r - tempR));
            } else if (diff > diffReq) {
                l++; // Even if l=r, it will be taken care in next iteration under diff<diffReq case
            } else {
                r++;
            }
        }
        return count;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
