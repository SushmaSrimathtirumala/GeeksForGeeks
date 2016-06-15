package Regular.DsAndUtils;

/**
 * Created by gakshintala on 6/10/16.
 */
public class Utils {
    public static void quickSort(int[] arr) {
        partition(arr, 0, arr.length-1);
    }
    
    private static void partition(int[] arr, int low, int pivot) {
        int right = pivot-1;
        int left = low;
        while(left < right) {
            while(left <= pivot && arr[left] < arr[pivot]) left++;
            while(right > low && arr[right] > arr[pivot]) right--;
            if(left<right) swap(arr, left, right);
        }
        swap(arr,left,pivot);
        if(left+1 < pivot) partition(arr, left+1, pivot);
        if(low < left-1) partition(arr, low, left-1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    
    public static void printTreeInorder(TreeNode root) {
        if(root==null) return;
        printTreeInorder(root.left);
        System.out.print(root+" ");
        printTreeInorder(root.right);
    }

    public static void printSLL(SLLNode head) {
        while(head!=null) {
            System.out.print(head+" -> ");
            head = head.next;
        }
    }

    public static void printDLL(DLLNode head) {
        while(head!=null) {
            System.out.print(head+" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static int findLLLength(SLLNode head) {
        int count=0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
    
    public static void treeInorder(TreeNode root) {
        if(root==null) return;
        treeInorder(root.left);
        System.out.print(root+" ");
        treeInorder(root.right);
    }
}
