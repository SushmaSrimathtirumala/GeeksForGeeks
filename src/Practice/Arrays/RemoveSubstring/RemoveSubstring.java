package Practice.Arrays.RemoveSubstring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by gakshintala on 6/24/16.
 */
public class RemoveSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int subStringLen = scn.nextInt();
            String[] subStrings = new String[subStringLen];
            fillArray(subStrings, scn);
            char[] str = scn.next().toCharArray();
            printCharArr(removeSubstring(str, subStrings));
        }
    }

    private static void fillArray(String[] subStrings, Scanner scn) {
        for (int i = 0; i < subStrings.length; i++) {
            subStrings[i] = scn.next();
        }
    }

    private static void printCharArr(char[] chars) {
        StringBuilder strb = new StringBuilder();
        for (char c : chars) {
            strb.append(c);
        }
        System.out.println(strb);
    }

    private static char[] removeSubstring(char[] str, String[] subStrings) {
        Arrays.sort(subStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        });
        int j = 0, strIndex = 0, strLen = str.length;
        while (j < strLen) {
            for (int i = 0; i < subStrings.length; i++) {
                if (isSubstringMatch(str, subStrings[i].toCharArray(), j)) {
                    j += subStrings[i].length();
                }
            }

            if (j >= strLen) break;

            for (int i = 0; i < subStrings.length; i++) {
                int subStrLen = subStrings[i].length();
                if (subStrLen > 1 && subStrings[i].charAt(subStrLen - 1) == str[j]
                        && (strIndex - (subStrLen - 2)) >= 0
                        && isSubstringMatch(str, subStrings[i].substring(0, subStrLen - 1).toCharArray(), strIndex - (subStrLen - 2))) {
                    strIndex -= (subStrLen - 2);
                }
            }
            str[strIndex++] = str[j++];
        }

        if (strIndex - subStrings[0].length() >= 0
                && isSubstringMatch(str, subStrings[0].toCharArray(), strIndex - subStrings[0].length())) {
            strIndex -= subStrings[0].length();
        }

        return Arrays.copyOfRange(str, 0, strIndex);
    }

    private static boolean isSubstringMatch(char[] str, char[] subString, int j) {
        for (char c : subString) {
            if (str[j] != c) {
                return false;
            }
            j++;
        }
        return true;
    }
}
