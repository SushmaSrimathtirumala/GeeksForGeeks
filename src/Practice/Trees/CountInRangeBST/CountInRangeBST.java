package Practice.Trees.CountInRangeBST;

import DsAndUtils.TreeNode;

import java.util.Scanner;

import static DsAndUtils.Utils.insertNodeIntoTree;

public class CountInRangeBST {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            TreeNode root = readTree(scn, len);
            int low = scn.nextInt();
            int high = scn.nextInt();
            System.out.println(getCount(root, low, high));
        }
    }

    private static int getCount(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (isInRange(root.val, low, high)) {
            return 1 + getCount(root.left, low, high)
                    + getCount(root.right, low, high);
        }

        if (root.val < low) {
            return getCount(root.right, low, high);
        }

        return getCount(root.left, low, high);
    }

    private static boolean isInRange(int val, int low, int high) {
        return val >= low && val <= high;
    }

    private static TreeNode readTree(Scanner scn, int len) {
        TreeNode root = new TreeNode(scn.nextInt());
        for (int i = 0; i < len - 1; i++) {
            insertNodeIntoTree(root, scn.nextInt());
        }
        return root;
    }
}
