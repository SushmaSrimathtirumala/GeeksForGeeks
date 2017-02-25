package Regular.Trees.VerticalSum;

import DsAndUtils.DLLNode;
import DsAndUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static DsAndUtils.Utils.printDLL;

/**
 * Created by gakshintala on 6/11/16.
 */
public class VerticalSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(6));
        root.right().setRight(new TreeNode(7));

        Map<Integer, Integer> map = new HashMap<>();
        verticalSum(root, map, 0);
        System.out.println(map.values());

        DLLNode dll = new DLLNode(0);
        verticalSumSpaceOptimized(root, dll);
        while (dll.prev != null) dll = dll.prev;
        printDLL(dll);
    }

    private static void verticalSumSpaceOptimized(TreeNode root, DLLNode dll) {
        if (root == null) {
            return;
        }

        dll.val += root.val;

        // Creation of new nodes if required, and recur
        if (root.left != null && dll.prev == null) {
            dll.prev = new DLLNode(0);
            dll.prev.next = dll;
        }

        if (root.right != null && dll.next == null) {
            dll.next = new DLLNode(0);
            dll.next.prev = dll;
        }

        // Put the sum in next node if moving right or put in prev if moving left
        verticalSumSpaceOptimized(root.left, dll.prev);
        verticalSumSpaceOptimized(root.right, dll.next);
    }

    private static void verticalSum(TreeNode root, Map<Integer, Integer> map, int hd) {
        if (root == null) {
            return;
        }
        int prevSum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, prevSum + root.val);

        // Decrease horizontal distance as we move left and increase as we move right
        verticalSum(root.left, map, hd - 1);
        verticalSum(root.right, map, hd + 1);
    }
}
