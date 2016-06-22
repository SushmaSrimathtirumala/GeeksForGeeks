package Practice.Arrays.BettingGame;

import java.util.Scanner;

/**
 * Created by gakshintala on 6/14/16.
 */
public class BettingGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        String[] strings = new String[tests];
        for (int i = 0; i < tests; i++) {
            strings[i] = scn.next();
        }

        int initAmount = 4;
        for (String str : strings) {
            System.out.println(bettingOutcome(initAmount, str));
        }
    }

    private static int bettingOutcome(int amount, String str) {
        int bet = 1;
        for (char result : str.toCharArray()) {
            amount -= bet;
            if (amount < 0) {
                return -1;
            }
            if (result == 'W') {
                amount += 2 * bet;
                bet = 1;
            } else {
                bet *= 2;
            }
        }
        return amount;
    }
}
