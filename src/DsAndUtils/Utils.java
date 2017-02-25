package DsAndUtils;

/**
 * Created by gakshintala on 6/10/16.
 */
public class Utils {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int partitionPoint = partition(arr, low, high);

        if (partitionPoint - 1 > low) quickSort(arr, low, partitionPoint - 1);
        if (partitionPoint + 1 < high) quickSort(arr, partitionPoint + 1, high);
    }

    private static int partition(int[] arr, int low, int pivotPos) {
        int right = pivotPos - 1;
        int left = low;
        while (left < right) {
            while (left <= pivotPos && arr[left] < arr[pivotPos]) left++; // Note the <= in left<=pivotPos
            while (right > low && arr[right] > arr[pivotPos]) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, pivotPos);
        return left;
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        if (pos1 == pos2) return;
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void printTreeInorder(TreeNode root) {
        if (root == null) return;
        printTreeInorder(root.left);
        System.out.print(root + " ");
        printTreeInorder(root.right);
    }

    public static void printSLL(SLLNode head) {
        while (head != null) {
            System.out.print(head + " -> ");
            head = head.next;
        }
    }

    public static void printDLL(DLLNode head) {
        while (head != null) {
            System.out.print(head + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static int findLLLength(SLLNode head) {
        int count = 0;
        while (head != null) {
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
        if (root == null) return;
        treeInorder(root.left);
        System.out.print(root + " ");
        treeInorder(root.right);
    }
}
