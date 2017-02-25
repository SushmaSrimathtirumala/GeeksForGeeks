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
        SLLNode[] nodes = frontBackSplit(head);

        // Split each list further by recursion, in return u receive merged lists
        nodes[0] = mergeSortLL(nodes[0]);
        nodes[1] = mergeSortLL(nodes[1]);

        // Merge the merged lists further
        return sortAndMerge(nodes[0], nodes[1]);
    }

    private static SLLNode[] frontBackSplit(SLLNode source) {
        SLLNode[] nodes = new SLLNode[2];
        // if the length is just 1
        if (source == null || source.next == null) {
            nodes[0] = source;
            nodes[1] = null;
            return nodes;
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
        nodes[0] = source;
        nodes[1] = slow.next;
        slow.next = null; // Split
        return nodes;
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
