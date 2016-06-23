package Regular.Trees.DiagonalTreeTraversal;

import DsAndUtils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gakshintala on 6/21/16.
 */
public class DiagonalTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(10));

        root.left().setLeft(new TreeNode(1));
        root.left().setRight(new TreeNode(6));
        root.right().setRight(new TreeNode(14));

        root.left().right().setLeft(new TreeNode(4));
        root.left().right().setRight(new TreeNode(7));
        root.right().right().setLeft(new TreeNode(13));

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        diagonalTreeTraversal(root, map, 0);
        printDiagonalNodes(map);
    }

    private static void printDiagonalNodes(Map<Integer, List<TreeNode>> map) {
        map.values().forEach(System.out::println);
    }

    private static void diagonalTreeTraversal(TreeNode root, Map<Integer, List<TreeNode>> map, int diagonal) {
        if (root == null) {
            return;
        }
        List<TreeNode> diagonalList = map.get(diagonal);
        if (diagonalList == null) {
            diagonalList = new ArrayList<>();
            map.put(diagonal, diagonalList);
        }
        diagonalList.add(root);
        diagonalTreeTraversal(root.right, map, diagonal);
        diagonalTreeTraversal(root.left, map, diagonal + 1);
    }
}