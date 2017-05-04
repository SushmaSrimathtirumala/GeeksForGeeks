package Practice.LinkedLists.ReverseLLInGroups;

import DsAndUtils.SLLNode;

import java.util.Scanner;

import static DsAndUtils.Utils.printSLL;

/**
 * Created by Gopala Akshintala on 6/2/17.
 */
public class ReverseLLInGroups {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            SLLNode sllNode = new SLLNode(scn.nextInt());
            SLLNode head = sllNode;
            while (len-- > 1) {
                sllNode.next = new SLLNode(scn.nextInt());
                sllNode = sllNode.next;
            }
            int group = scn.nextInt();
            printSLL(reverseLLInBlocks(head, group));
        }
    }

    private static SLLNode reverseLLInBlocks(SLLNode head, int group) {
        SLLNode prev = null, next = head, cur = head;
        int count = 0;
        while (count < group && next != null) {
            cur = next;
            next = next.next;
            cur.next = prev;
            prev = cur;
            count++;
        }
        if (next != null) {
            head.next = reverseLLInBlocks(next, group);
        }
        return prev;
    }
}
