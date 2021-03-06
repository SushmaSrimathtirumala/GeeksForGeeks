package Regular.Trees.MirrorTree;

import DsAndUtils.TreeNode;

import static DsAndUtils.Utils.printTreeInorder;

/**
 * Created by gakshintala on 6/10/16.
 */
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode t1, t2, t3, t4, t5, t6, t7, t8;
        t8 = new TreeNode(8, null, null);
        t7 = new TreeNode(7, null, null);
        t6 = new TreeNode(6, null, null);
        t5 = new TreeNode(5, null, null);
        t4 = new TreeNode(4, t8, null);
        t3 = new TreeNode(3, t6, t7);
        t2 = new TreeNode(2, t4, t5);
        t1 = new TreeNode(1, t2, t3);

        printTreeInorder(t1);
        mirrorTree(t1);

        System.out.println();
        printTreeInorder(t1);
    }

    private static void mirrorTree(TreeNode root) {
        if (root == null) return;
        // Bottom-up approach, post order traversal
        // Go as deep as possible, both on left and right side before swapping for the first time
        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
