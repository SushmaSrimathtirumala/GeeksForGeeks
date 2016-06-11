package LinkedLists.LLIntersection;

import DsAndUtils.SLLNode;

import static DsAndUtils.Utils.findLLLength;

/**
 * Created by gakshintala on 6/10/16.
 */
public class LLIntersection {
    public static void main(String[] args) {
        SLLNode l1, l2, l3, l4, l5;
        l5 = new SLLNode(5);
        l4 = new SLLNode(4, l5);
        l3 = new SLLNode(3, l4);
        l2 = new SLLNode(2, l3);
        l1 = new SLLNode(1, l2);

        SLLNode k1, k2, k3;
        k3 = new SLLNode(9, l3);
        k2 = new SLLNode(8, k3);
        k1 = new SLLNode(7, k2);

        System.out.println(mergePoing(l1, k1));
    }

    private static int mergePoing(SLLNode l1, SLLNode k1) {
        int lLength = findLLLength(l1);
        int kLength = findLLLength(k1);

        int lenDiff = Math.abs(lLength - kLength);

        if (lLength > kLength) {
            while (lenDiff-- > 0) l1 = l1.next;
        } else {
            while (lenDiff-- > 0) k1 = k1.next;
        }
        while (l1 != null && k1 != null && l1 != k1) {
            l1 = l1.next;
            k1 = k1.next;
        }
        return (l1 == null || k1 == null) ? l1.val : -1;
    }
}
