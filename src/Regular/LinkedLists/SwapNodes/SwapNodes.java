package Regular.LinkedLists.SwapNodes;

import DsAndUtils.SLLNode;

import static DsAndUtils.Utils.printSLL;

/**
 * Created by Gopala Akshintala on 2/25/17.
 */
public class SwapNodes {
    public static void main(String[] args) {
        SLLNode head = new SLLNode(7);
        head.add(6);
        head.add(5);
        head.add(4);
        head.add(3);
        head.add(2);
        head.add(1);

        swapNodes(head, 4, 3);
        swapNodes(head, 7, 1);
    }

    private static void swapNodes(SLLNode head, int x, int y) {
        SLLNode curX, curY, prevX, prevY;
        prevX = prevY = null;
        curX = curY = head;
        while (curX != null && curX.val != x) {
            prevX = curX;
            curX = curX.next;
        }
        while (curY != null && curY.val != y) {
            prevY = curY;
            curY = curY.next;
        }

        if (prevX != null) {
            prevX.next = curY;
        } else {
            head = curY; // if prevX = null, then x is head, so now assign to y
        }

        if(prevY != null) {
            prevY.next = curX;
        } else {
            head = curX;
        }

        // Swap next pointers
        SLLNode temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;

        printSLL(head);
        System.out.println();
    }
}
