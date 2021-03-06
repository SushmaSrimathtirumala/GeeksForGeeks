package Regular.LinkedLists.MergeSortLL;

import DsAndUtils.SLLNode;

import static DsAndUtils.Utils.printSLL;

/**
 * Created by Gopala Akshintala on 2/26/17.
 */
public class MergeSortLL {
    public static void main(String[] args) {
        SLLNode head = new SLLNode(4);
        head.next = new SLLNode(3);
        head.next.next = new SLLNode(5);
        head.next.next.next = new SLLNode(1);
        head.next.next.next.next = new SLLNode(2);
        printSLL(head);
        System.out.println();
        printSLL(mergeSortLL(head));

    }

    // The idea is to split the LL into smallest chains and merge them back
    private static SLLNode mergeSortLL(SLLNode head) {
        // When the list has only 1 element return it
        if (head == null || head.next == null) {
            return head;
        }
        // Split the LL into two list to the middle
        SLLNode middle = frontBackSplit(head);

        // Split each list further by recursion, in return we receive merged lists
        head = mergeSortLL(head);
        middle = mergeSortLL(middle);

        // Merge the merged lists further
        return sortAndMerge(head, middle);
    }

    private static SLLNode frontBackSplit(SLLNode source) {
        // if the length is just 1
        if (source == null || source.next == null) {
            return null;
        }
        // To find middle node to split
        SLLNode fast, slow;
        slow = source;
        fast = source.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        SLLNode node = slow.next;
        slow.next = null; // Split
        return node;
    }

    private static SLLNode sortAndMerge(SLLNode a, SLLNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        SLLNode result;
        // Merging recursively
        if (a.val <= b.val) {
            result = a;
            result.next = sortAndMerge(a.next, b);
        } else {
            result = b;
            result.next = sortAndMerge(a, b.next);
        }
        return result;
    }
}
