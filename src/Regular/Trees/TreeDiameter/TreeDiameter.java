package Regular.Trees.TreeDiameter;

import DsAndUtils.TreeNode;

/**
 * Created by gakshintala on 6/10/16.
 */
public class TreeDiameter {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(diameter(treeNode1, new Height()));
    }

    private static int diameter(TreeNode root, Height height) {
        if (root == null) {
            // This is a bottom-up approach. So from top, we pass height as one if there is a valid node, so if the 
            // node is null, we set it to 0
            height.height = 0;
            return 0;
        }
        // Objects are used as unique refs across recursion
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        leftHeight.height++;
        rightHeight.height++;
        int leftDiameter = diameter(root.left, leftHeight);
        int rightDiameter = diameter(root.right, rightHeight);

        // Height builds-up, bottom-up. This can be the leftHeight or rightHeight passed from parent recursive call
        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

        // leftHeight.height + rightHeight.height + 1, here +1 is for root
        // Diameter builds with heights at first, and gradually bubbles-up
        return Math.max(leftHeight.height + rightHeight.height + 1, Math.max(leftDiameter, rightDiameter));
    }
}

class Height {
    public int height = 0;
}
