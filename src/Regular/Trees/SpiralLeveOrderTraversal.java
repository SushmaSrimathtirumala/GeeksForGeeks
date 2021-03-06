package Regular.Trees;

import DsAndUtils.TreeNode;

import java.util.Stack;

/**
 * Created by Go on 9-4-16.
 */
public class SpiralLeveOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, treeNode8, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        printInSpiral(treeNode1);
    }

    private static void printInSpiral(TreeNode root) {
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();

        s1.add(root);
        System.out.println(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            System.out.println(s2);

            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            System.out.println(s1);
        }
    }
}
