package Regular.BackTracking.KSwapsMaxNum;

/**
 * Created by gakshintala on 6/27/16.
 */
public class KSwapsMaxNum {
    public static void main(String[] args) {
        String str1 = "129814999";
        String str2 = "7899";
        int swaps = 4;
        System.out.println(findMaxAfterKSwaps(str1, swaps, Integer.valueOf(str1)));
        System.out.println(findMaxAfterKSwaps(str2, swaps, Integer.valueOf(str2)));
    }
    
    private static int findMaxAfterKSwaps(String str, int swaps, int max) {
        // Base Condition
        if (swaps > 0 && !isDigitsDescendingSorted(max)) {
            int len = str.length();
            // Loop, Checking combinations by swapping every char with the every greater char following it.
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    // isValid Condition-1
                    if (str.charAt(i) < str.charAt(j)) {
                        str = swap(str, i, j);
                        System.out.println(str);
                        // isValid Condition-2
                        if (Integer.valueOf(str) > max) {
                            max = findMaxAfterKSwaps(str, swaps - 1, Integer.valueOf(str));
                            if(isDigitsDescendingSorted(max)) { // We can stop when all digits are in descending 
                                // order coz that is the max num possible with those set of digits
                                return max;
                            }
                        }
                    }
                    // Backtracking is auto, as swaps retains its original value.
                }
            }
        }
        // Simply swapping the highest to left-end won't work. 
        // Ex: 7899 for 2 swaps -> 9879 -> 9978. But real answer is 9987 
        return max;
    }

    private static boolean isDigitsDescendingSorted(int num) {
        int digit1 = num%10;
        while(num > 10) {
            num/=10;
            int digit2 = num%10;
            if(digit2 < digit1) {
                return false;
            }
            digit1 = digit2;
        }
        return true;
    }

    private static String swap(String str, int i, int j) {
        char[] strArr = str.toCharArray();
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return new String(strArr);
    }
}
