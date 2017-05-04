package Practice.Arrays.NutsBolts;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/21/16.
 */
public class NutsBolts {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();

            char[] nuts = new char[len];
            fillArray(nuts, scn);

            char[] bolts = new char[len];
            fillArray(bolts, scn);

            matchNutsToBolts(nuts, bolts);

            printArr(nuts);
            printArr(bolts);
        }
    }

    private static void printArr(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void matchNutsToBolts(char[] nuts, char[] bolts) {
        matchNutsToBolts(nuts, 0, nuts.length - 1, bolts);
    }

    private static void matchNutsToBolts(char[] nuts, int low, int high, char[] bolts) {
        // Partition nuts.
        int partitionPoint = partition(nuts, low, high, bolts[high]);

        // Partition bolts with nut at partition point. Post partition, the nut and bolt at partition point match.
        partition(bolts, low, high, nuts[partitionPoint]);

        // Recur this for left and right half.
        if (low < partitionPoint - 1) matchNutsToBolts(nuts, low, partitionPoint - 1, bolts);
        if (high > partitionPoint + 1) matchNutsToBolts(nuts, partitionPoint + 1, high, bolts);
    }

    private static int partition(char[] arr, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot) {
                swap(arr, j, high);
                j--; // To compensate the ++ in nextRight iteration, so that the newly swapped element from high is checked.
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void fillArray(char[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.next().charAt(0);
        }
    }

    public static void swap(char[] arr, int pos1, int pos2) {
        if (pos1 == pos2) return;
        char temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
