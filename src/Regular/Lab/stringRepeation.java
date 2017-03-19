package Regular.Lab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gopala Akshintala on 3/14/17.
 */
public class stringRepeation {
    public static void main(String[] args) {
        String[] votes = {"alex", "michael", "harry", "dave","victor", "michael", "michael", "dave", "dave","dave","dave"};
        Map<String, Integer> map = new HashMap<>();
        for(String vote: votes) {
            Integer freq = map.get(vote);
            if(freq == null) {
                map.put(vote, 1);
            } else {
                map.put(vote, freq+1);
            }
        }

        Integer max = Integer.MIN_VALUE;
        String winner = "";
        for(Map.Entry vote: map.entrySet()) {
            Integer freq = (Integer) vote.getValue();
            String name = (String) vote.getKey();
            if(max <= freq) {
                max = freq;
                winner = name.compareTo(winner) > 0 ? winner : name;
            }
        }
        System.out.println(winner);
    }
}
