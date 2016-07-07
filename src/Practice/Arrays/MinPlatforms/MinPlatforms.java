package Practice.Arrays.MinPlatforms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gakshintala on 6/22/16.
 */
public class MinPlatforms {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);

            int[] dep = new int[len];
            fillArray(dep, scn);

            System.out.println(minPlatforms(arr, dep));
        }
    }

    private static int minPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        // Just like Merge sort
        int len = arr.length;
        int arrivals = 0, maxArrivals = 1, i = 0, j = 0; // maxArrivals is atleast 1
        while (i < len && j < len) {
            if (arr[i] < dep[j]) {
                i++;
                arrivals++;
                maxArrivals = Math.max(arrivals, maxArrivals);
            } else {
                j++;
                arrivals--; // Can go negative for departure times for next day which are less than arrival times. 
                // It's ok, they get neutralized as we encounter arrival times.
            }
        }
        // No need of this code, cause here the departure time lesser than arrival time is depicted by train leaving 
        // next day. So we encounter their departures earlier than their arrival in the sorted array.
        /*if (j == len) {
            maxArrivals += (len - 1 - i);
        }*/
        return maxArrivals;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
