package LinkedLists.ReverseLL;

import DsAndUtils.SLLNode;

import static DsAndUtils.Utils.printLinkedList;

/**
 * Created by gakshintala on 6/10/16.
 */
public class ReverseLL {
    public static void main(String[] args) {
        SLLNode l1, l2, l3, l4;
        l1 = new SLLNode(1);
        l2 = new SLLNode(2);
        l3 = new SLLNode(3);
        l4 = new SLLNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        reverseLinkedList(l1);
        printLinkedList(l4);
    }

    private static void reverseLinkedList(SLLNode head) {
        SLLNode prev = null, cur, next = head;

        while (next != null) {
            cur = next;
            // Preserve the next node and set it to prev
            next = next.next;
            cur.next = prev;

            prev = cur;
        }

    }
}