package Practice.StkAndQue.NextGreaterForAll;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by gakshintala on 6/13/16.
 */
public class NextGreaterForAll {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = fillArray(len, scn);
            findNextGreatest(arr);
        }
    }

    private static void findNextGreatest(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> eleToGreaterEleMap = new HashMap<>();
        stk.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            // Pop until a lesser element in found.
            while (!stk.isEmpty() && arr[i] > stk.peek()) {
                eleToGreaterEleMap.put(stk.pop(), arr[i]);
            }
            stk.push(arr[i]);
        }
        // Pop the remaining in stack
        while (!stk.isEmpty()) {
            eleToGreaterEleMap.put(stk.pop(), -1);
        }
        printNextGreatest(eleToGreaterEleMap, arr);
    }

    private static void printNextGreatest(Map<Integer, Integer> eleToGreaterEleMap, int[] arr) {
        for (int ele : arr) {
            System.out.print(eleToGreaterEleMap.get(ele) + " ");
        }
        System.out.println();
    }

    private static int[] fillArray(int len, Scanner scn) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
