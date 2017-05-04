package Practice.Arrays.BiggestNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BiggestNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int[] arr = readArray(scn, len);
            System.out.println(biggestNumberFromArray(arr));
        }
    }

    private static String biggestNumberFromArray(int[] arr) {
        List<Integer> arrList = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> { // {9,6} -> 96 or 69, then 9 should come before 6 in sorted order
                    String ba = String.valueOf(b) + String.valueOf(a);
                    String ab = String.valueOf(a) + String.valueOf(b);
                    return Integer.compare(Integer.parseInt(ba), Integer.parseInt(ab)); // Note we are comparing in reverse
                }).collect(Collectors.toList());

        return arrList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static int[] readArray(Scanner scn, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
