package DsAndUtils;

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

    static void swap(int[] arr, int left, int right) {
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

    public static void printLinkedList(SLLNode head) {
        while(head!=null) {
            System.out.print(head+" -> ");
            head = head.next;
        }
    }

    public static int findLLLength(SLLNode head) {
        int count=0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
