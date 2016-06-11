package Trees.PrintPath;

import DsAndUtils.TreeNode;

import java.util.Arrays;

/**
 * Created by gakshintala on 6/10/16.
 */
public class PrintPath {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        TreeNode[] path = new TreeNode[depth(treeNode1)];
        printPath(treeNode1, 0, path);
    }

    private static void printPath(TreeNode root, int level, TreeNode[] path) {
        path[level] = root;
        
        if (root.left == null && root.right == null) {
            System.out.println(Arrays.toString(path));
            path[level] = null; // Like erasing these elements for backtracking
            return;
        }
        printPath(root.left, level + 1, path);
        printPath(root.right, level + 1, path);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
