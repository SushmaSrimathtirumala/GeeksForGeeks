package Practice.Trees.IsPreOrderBST;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by gakshintala on 6/12/16.
 */
public class IsPreOrderBST {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] pre = new int[len];
            fillArray(pre, scn);
            System.out.println(isPreOrderBST(pre) ? 1: 0);
        }
    }
    
    private static boolean isPreOrderBST(int[] pre) {
        Stack<Integer> stk = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] < root) {
                return false;
            }

            while (!stk.isEmpty() && pre[i] > stk.peek()) {
                root = stk.pop();
            }
            stk.push(pre[i]);
        }
        return true;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}

