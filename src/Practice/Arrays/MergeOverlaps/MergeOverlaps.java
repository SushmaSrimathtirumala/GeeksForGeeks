package Practice.Arrays.MergeOverlaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Gopala Akshintala on 10/04/17.
 */
public class MergeOverlaps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        List<List<Interval>> inputIntervals = new ArrayList<>();
        while (tests-- > 0) {
            int len = scn.nextInt();
            List<Interval> intervals = readIntervals(scn, len);
            inputIntervals.add(intervals);
        }

        inputIntervals.forEach(intervals -> {
            mergeIntervals(intervals).forEach(System.out::print);
            System.out.println();
        });
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        List<Interval> sortedIntervals =
                intervals.stream().sorted(Comparator.comparingInt(i -> i.startTime)).collect(Collectors.toList());
        Interval prev = sortedIntervals.get(0);
        for (Interval cur : sortedIntervals) {
            if (prev.endTime >= cur.startTime) {
                prev.endTime = Math.max(prev.endTime, cur.endTime);
            } else {
                mergedIntervals.add(prev);
                prev = cur;
            }
        }
        mergedIntervals.add(prev);
        return mergedIntervals;
    }


    private static List<Interval> readIntervals(Scanner scn, int len) {
        List<Interval> intervals = new ArrayList<>();
        while (len-- > 0) {
            Interval interval = new Interval();
            interval.startTime = scn.nextInt();
            interval.endTime = scn.nextInt();
            intervals.add(interval);
        }
        return intervals;
    }

}

class Interval {
    int startTime;
    int endTime;

    @Override
    public String toString() {
        return startTime + " " + endTime + " ";
    }
}
