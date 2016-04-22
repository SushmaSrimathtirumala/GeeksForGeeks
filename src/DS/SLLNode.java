package DS;

/**
 * Created by gakshintala on 4/22/16.
 */
public class SLLNode {
    public int val;
    public SLLNode next;
    public SLLNode(int val) {
        this.val=val;
    }
    public SLLNode(int val, SLLNode next) {
        this.val=val;
        this.next=next;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
