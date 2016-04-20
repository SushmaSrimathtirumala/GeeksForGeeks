package Trees.SwappedNodes;

import DS.TreeNode;

/**
 * Created by gakshintala on 4/13/16.
 */
public class SwappedNodes {
    public static void main(String[] args) {
        TreeNode bstNode7 = new TreeNode(7, null, null);
        TreeNode bstNode6 = new TreeNode(5, null, null);
        TreeNode bstNode5 = new TreeNode(2, null, null);
        TreeNode bstNode4 = new TreeNode(1, null, null);
        TreeNode bstNode3 = new TreeNode(6, bstNode6, bstNode7);
        TreeNode bstNode2 = new TreeNode(3, bstNode4, bstNode5);
        TreeNode bstNode1 = new TreeNode(4, bstNode2, bstNode3);
        
        printInorder(bstNode1);
        System.out.println();
        
        
        TreeNode[] refs = correctSwappedNodes(bstNode1, null, new TreeNode[3]);
        
        if(refs[0]==null && refs[1]==null && refs[2]==null) {
            System.out.println("Tree doesn't contain any swapped Nodes");
        }
        else if(refs[2]==null)
            swap(refs[0],refs[1]);
        else 
            swap(refs[0],refs[2]);
        
        printInorder(bstNode1);
    }

    private static void swap(TreeNode first, TreeNode last) {
        int temp = first.data;
        first.data = last.data;
        last.data = temp;
    }

    private static TreeNode[] correctSwappedNodes(TreeNode root, TreeNode parent, TreeNode[] refs) {
        if(root==null) return refs;
        correctSwappedNodes(root.left, refs[0], refs); // Before node of left most node in left tree is null
        
        if(parent!=null && root.data < parent.data) {
            if(refs[0]==null) { // ref[1] is if adjectecent nodes are swapped, in that case we wont find another anamoly
                refs[0] = root;
                refs[1] = parent;
            } else {
                refs[2] = root;
                return refs;
            }
        }
        correctSwappedNodes(root.right, root, refs);
        return refs;
    }

    private static void printInorder(TreeNode root) {
        if(root==null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}