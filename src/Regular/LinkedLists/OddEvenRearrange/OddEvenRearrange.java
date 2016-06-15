package Regular.LinkedLists.OddEvenRearrange;

import Regular.DsAndUtils.SLLNode;

import static Regular.DsAndUtils.Utils.printSLL;

/**
 * Created by gakshintala on 4/22/16.
 */
public class OddEvenRearrange {
    public static void main(String[] args) {
        SLLNode head = new SLLNode(1);
        head.next = new SLLNode(2);
        head.next.next = new SLLNode(3);
        head.next.next.next = new SLLNode(4);
        head.next.next.next.next = new SLLNode(5);

        rearrangeEvenOdd(head);
        printSLL(head);
    }
    
    private static void rearrangeEvenOdd(SLLNode head) {
        SLLNode odd = head;
        SLLNode even = head.next;
        
        SLLNode evenFirst = even;
        while (true) {
            // Check even.next before setting to odd
            // If list ended, link both even and odd lists
            if (odd == null || even == null || even.next == null) {
                odd.next = evenFirst;
                break;
            }

            odd.next = even.next;
            // This kind of makes 2 jumps
            odd = odd.next;

            // Check odd.next before setting to even
            if (odd.next == null) {
                odd.next = evenFirst;
                even.next = null;
                break;
            }

            even.next = odd.next;
            even = even.next;
        }
    }
}
