package Arrays.LongestUniqueCharSubString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gakshintala on 6/10/16.
 */
public class LongestUniqueCharSubString {
    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println(longestUniqueCharSubString(str));
    }

    private static int longestUniqueCharSubString(String str) {
        int max=0, count=0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                max = Math.max(max,count);
                count = i - map.get(c);
            } else {
                map.put(c,i);
                count++;
            }
        }
        
        return Math.max(max,count);
    }
}
