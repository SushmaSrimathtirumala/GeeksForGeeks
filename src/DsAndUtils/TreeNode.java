package DsAndUtils;

/**
 * Created by gakshintala on 3/22/16.
 */
public class TreeNode {
    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left=left;
        this.right=right;
    }

    public TreeNode(int data, TreeNode left, TreeNode right, int level){
        this(data,left,right);
        this.level = level;
    }
    
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    public int level;

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}