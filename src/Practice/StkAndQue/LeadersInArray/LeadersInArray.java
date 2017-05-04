package Practice.StkAndQue.LeadersInArray;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by gakshintala on 7/3/16.
 */
public class LeadersInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            printLeader(arr);
        }
    }

    private static void printLeader(int[] arr) {
        int len = arr.length;
        int leader = arr[len - 1];
        Stack<Integer> stk = new Stack<>();
        stk.push(leader);
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                stk.push(leader);
            }
        }
        printStack(stk);
    }

    private static void printStack(Stack<Integer> stk) {
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}
