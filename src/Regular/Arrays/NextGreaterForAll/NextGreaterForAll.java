package Regular.Arrays.NextGreaterForAll;

import java.util.Stack;

/**
 * Created by gakshintala on 6/13/16.
 */
public class NextGreaterForAll {
    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        printNextGreat(arr);
    }

    private static void printNextGreat(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            // Pop until a lesser element in found.
            while (!stk.isEmpty() && arr[i] > stk.peek()) {
                System.out.println(stk.pop() + " -> " + arr[i]);
            }
            stk.push(arr[i]);
        }
        // Pop the remaining in stack
        while (!stk.isEmpty()) {
            System.out.println(stk.pop() + " -> " + -1);
        }
    }
}
