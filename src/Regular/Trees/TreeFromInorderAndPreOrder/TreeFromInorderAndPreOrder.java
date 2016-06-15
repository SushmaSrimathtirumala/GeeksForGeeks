package Regular.Trees.TreeFromInorderAndPreOrder;

import Regular.DsAndUtils.TreeNode;
import Regular.DsAndUtils.Utils;

/**
 * Created by gakshintala on 6/12/16.
 */
public class TreeFromInorderAndPreOrder {
    public static void main(String[] args) {
        char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
        char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};

        Utils.treeInorder(treeFromInorderAndPreOrder(in, pre, 0, pre.length, new Index(0)));
    }

    private static TreeNode treeFromInorderAndPreOrder(char[] in, char[] pre, int left, int right, Index index) {
        // This is similar to BST from Preorder. Preorder drives the recursion. Since this is not BST, instead of 
        // max-min, we have left-right and they are determined using Inorder.
        // This base check can also be replaced by if(left < right), and place optimization outside of it
        if (index.index < pre.length) {
            // Simple optimization to avoid recursive call leaf nodes. Since recursion ends here, no need to check 
            // for left-right range below
            if(left==right) {
                return new TreeNode(pre[index.index++]);
            }
            char val = pre[index.index];
            int valInorderPos = findInInorder(val, in);
            // If condition for checking left-right range can be omitted due to optimization above
            TreeNode root = new TreeNode(val);
            index.index++;
            root.left = treeFromInorderAndPreOrder(in, pre, left, valInorderPos - 1, index);
            root.right = treeFromInorderAndPreOrder(in, pre, valInorderPos + 1, right, index);
            return root;
        }
        return null;
    }

    private static int findInInorder(int val, char[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val) return i;
        }
        return -1;
    }
}

class Index {
    public int index;
    public Index(int index) {
        this.index = index;
    }
}