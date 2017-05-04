package Practice.Trees.BottomViewTree;

import java.util.HashMap;
import java.util.Map;

public class BottomViewTree {
    public static void main(String[] args) {
        DsAndUtils.TreeNode root = new DsAndUtils.TreeNode(20);
        root.left = new DsAndUtils.TreeNode(8);
        root.right = new DsAndUtils.TreeNode(22);
        root.left.left = new DsAndUtils.TreeNode(5);
        root.left.right = new DsAndUtils.TreeNode(3);
        root.right.left = new DsAndUtils.TreeNode(4);
        root.right.right = new DsAndUtils.TreeNode(25);
        root.left.right.left = new DsAndUtils.TreeNode(10);
        root.left.right.right = new DsAndUtils.TreeNode(14);

        Map<Integer, TreeNode> map = new HashMap<>();
        constructBottomView(root, map, 0, 0);
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> System.out.print(entry.getValue().val + " "));
    }

    private static void constructBottomView(DsAndUtils.TreeNode root, Map<Integer, TreeNode> map, int hd, int height) {
        if (root == null) {
            return;
        }

        TreeNode node = map.get(hd);
        if (node == null || node.height <= height) {
            map.put(hd, new TreeNode(root.val, height));
        }

        constructBottomView(root.left, map, hd - 1, height + 1);
        constructBottomView(root.right, map, hd + 1, height + 1);
    }
}

class TreeNode {
    int val;
    int height;

    public TreeNode(int val, int height) {
        this.val = val;
        this.height = height;
    }
}


