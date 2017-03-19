package Regular.Trees.KthLargestElement;

import DsAndUtils.TreeNode;

/**
 * Created by Gopala Akshintala on 2/25/17.
 */
public class KthLargestElement {
    private static int k = 3;

    public static void main(String[] args) {
        TreeNode bstNode7 = new TreeNode(7, null, null);
        TreeNode bstNode5 = new TreeNode(5, null, null);
        TreeNode bstNode3 = new TreeNode(3, null, null);
        TreeNode bstNode1 = new TreeNode(1, null, null);
        TreeNode bstNode6 = new TreeNode(6, bstNode5, bstNode7);
        TreeNode bstNode2 = new TreeNode(2, bstNode1, bstNode3);
        TreeNode bstNode4 = new TreeNode(4, bstNode2, bstNode6);

        reverseInorderTraversal(bstNode4);
    }

    private static void reverseInorderTraversal(TreeNode root) {
        if (root == null || k <= 0) return;

        reverseInorderTraversal(root.right);
        k--;
        if (k == 0) {
            System.out.println(root.val);
            return;
        }
        reverseInorderTraversal(root.left);
    }
}
