package DS;

/**
 * Created by gakshintala on 3/22/16.
 */
public class TreeNode {
    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left=left;
        this.right=right;
    }
    public int data;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
