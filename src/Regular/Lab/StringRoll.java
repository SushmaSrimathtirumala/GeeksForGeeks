package Regular.Lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 3/14/17.
 */
public class StringRoll {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char[] strChar = str.toCharArray();
        int rollLen = scn.nextInt();
        int[] rolls = new int[rollLen];
        for (int i = 0; i < rollLen; i++) {
            rolls[i] = scn.nextInt();
        }

        System.out.println(rollString(strChar, rolls));
    }

    private static String rollString(char[] strChar, int[] roll) {
        Arrays.sort(roll);
        int rollLen = roll.length;
        int len = strChar.length;
        int rollStart = 0;
        for (int i = 0; i < roll.length;) {
            for (int j = rollStart; j < len && j < roll[i]; j++) {
                strChar[j] += rollLen;
                if (strChar[j] > 'z') {
                    strChar[j] = (char) ('a' + strChar[j] - 'z' - 1);
                }
            }
            i++;
            rollStart = roll[i] - roll[i-1];
            rollLen--;
        }
        return new String(strChar);
    }
}
