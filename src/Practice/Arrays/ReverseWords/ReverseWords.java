package Practice.Arrays.ReverseWords;

import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 5/21/17.
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            String str = scn.next();
            System.out.println(reverseWords(str.toCharArray()));
        }
    }

    private static String reverseWords(char[] str) {
        int len = str.length;
        int wordBeginIndex = -1;
        for (int i = 0; i < len; i++) { // Leading spaces shall be taken care, as they don't satisfy any of the if conditions.
            // wordBeginIndex is not set until a non-space character is encountered. For Multiple spaces and leading spaces
            if (wordBeginIndex == -1 && str[i] != '.') {
                wordBeginIndex = i;
            }
            // End of string or Space character.
            if ((wordBeginIndex != -1) && ((i == len - 1)) || (str[i + 1] == '.')) {
                reverse(wordBeginIndex, i, str);
                wordBeginIndex = -1;
            }
        }
        // Reverse the entire string
        return String.valueOf(reverse(0, len - 1, str));
    }

    private static char[] reverse(int begin, int end, char[] str) {
        int low = begin;
        int high = end;

        while (low < high) {
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
        return str;
    }
}
