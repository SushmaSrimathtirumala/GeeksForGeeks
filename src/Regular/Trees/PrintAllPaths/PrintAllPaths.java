package Regular.Trees.PrintAllPaths;

import DsAndUtils.TreeNode;

import java.util.Arrays;

import static DsAndUtils.Utils.treeDepth;

/**
 * Created by gakshintala on 6/10/16.
 */
public class PrintAllPaths {
    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        TreeNode[] path = new TreeNode[treeDepth(treeNode1)];
        printPath(treeNode1, 0, path);
    }

    private static void printPath(TreeNode root, int level, TreeNode[] path) {
        path[level] = root;

        if (root == null || (root.left == null && root.right == null)) {
            System.out.println(Arrays.toString(path));
            path[level] = null; // Like erasing these elements for backtracking
            return;
        }

        level++;

        printPath(root.left, level, path);
        printPath(root.right, level, path);
    }
}
