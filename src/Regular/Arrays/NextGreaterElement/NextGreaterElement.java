package Regular.Arrays.NextGreaterElement;

import java.util.Stack;

/**
 * Created by gakshintala on 4/29/16.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        printNextGreaterElement(arr);
    }

    private static void printNextGreaterElement(int[] arr) {
        int len = arr.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        
        // Idea of using a stack is to have control over the history of elements traversed.
        for (int i = 1; i < len; i++) {
            if (arr[i] < stk.peek()) {
                stk.push(arr[i]);
            } else {
                // Pop stack for all elements less than the current
                while (!stk.isEmpty() && arr[i] > stk.peek()) {
                    System.out.println(stk.pop() + " -> " + arr[i]);
                }
                stk.push(arr[i]);
            }
        }
        
        // Remaining elements won't have any heighest
        for(int ele:stk) {
            System.out.println(ele + " --> " + -1);
        }
    }

}
