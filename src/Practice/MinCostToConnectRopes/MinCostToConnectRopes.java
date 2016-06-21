package Practice.MinCostToConnectRopes;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by gakshintala on 6/20/16.
 */
public class MinCostToConnectRopes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            System.out.println(minCostToConnectRopes(arr));
        }
    }

    private static int minCostToConnectRopes(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int e : arr) {
            heap.add(e);
        }
        int cost = 0;

        while (heap.size() > 1) {
            int e1 = heap.poll();
            int e2 = heap.poll();
            int curCost = e1 + e2;
            cost += curCost;
            heap.add(curCost);
        }

        return cost;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
