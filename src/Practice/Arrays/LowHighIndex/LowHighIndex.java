package Practice.Arrays.LowHighIndex;

import java.util.Scanner;

public class LowHighIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            int searchNum = scn.nextInt();
            int[] arr = readArray(scn, len);
            printFirstLastOccurence(arr, searchNum);
        }
    }

    private static void printFirstLastOccurence(int[] arr, int searchNum) {
        int firstOccurrence = findFirstOccurrence(arr, searchNum, 0, arr.length - 1);
        if(firstOccurrence == -1) {
            System.out.println(-1);
            return;
        }
        int lastOccurrence = findLastOccurrence(arr, searchNum, firstOccurrence, arr.length-1);
        System.out.println(firstOccurrence + " " + lastOccurrence);
    }

    private static int findLastOccurrence(int[] arr, int searchNum, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right)/2;
        if((mid == arr.length - 1 || arr[mid + 1] > searchNum) && arr[mid] == searchNum) {
            return mid;
        }
        if(arr[mid] > searchNum) {
            return findLastOccurrence(arr, searchNum, left, mid - 1);
        }
        return findLastOccurrence(arr, searchNum, mid + 1, right);
    }

    private static int findFirstOccurrence(int[] arr, int searchNum, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if ((mid == 0 || arr[mid - 1] < arr[mid]) && arr[mid] == searchNum) {
            return mid;
        }
        if (arr[mid] < searchNum) {
            return findFirstOccurrence(arr, searchNum, mid + 1, right);
        }
        return findFirstOccurrence(arr, searchNum, left, mid - 1);
    }

    private static int[] readArray(Scanner scn, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
