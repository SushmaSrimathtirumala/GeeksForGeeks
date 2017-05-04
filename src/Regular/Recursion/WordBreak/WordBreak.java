package Regular.Recursion.WordBreak;

import java.util.*;

/**
 * Created by Gopala Akshintala on 5/3/17.
 */
public class WordBreak {
    private static Set<String> dictionary = new HashSet<>(Arrays.asList("mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and", "go", "i", "love", "ice", "cream"));

    public static void main(String[] args) {
        String word = "iloveicecreamandmango";
        wordBreak(word, "");
    }

    private static void wordBreak(String word, String result) {
        int len = word.length();
        for (int i = 1; i <= len; i++) { // Loop takes care of starting different branches of recursion for common letter words
            String subWord = word.substring(0, i);
            if (dictionary.contains(subWord)) {
                if (i == len) {
                    System.out.println(result + subWord);
                    return;
                }
                wordBreak(word.substring(i, len), result + subWord + " ");
            }
        }
    }

}
