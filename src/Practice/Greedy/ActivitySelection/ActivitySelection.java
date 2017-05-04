package Practice.Greedy.ActivitySelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int len = scn.nextInt();
            List<Activity> activities = readActivities(scn, len);
            printSelectedActivities(activities);
            System.out.println();
        }
    }

    private static void printSelectedActivities(List<Activity> activities) {
        Collections.sort(activities);
        Activity prevActivity = activities.get(0);
        System.out.print(prevActivity.index + " ");
        for (int i = 1; i < activities.size(); i++) {
            Activity curActivity = activities.get(i);
            if (curActivity.startTime >= prevActivity.finishTime) {
                System.out.print(curActivity.index + " ");
                prevActivity = curActivity;
            }
        }
    }

    private static List<Activity> readActivities(Scanner scn, int len) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Activity activity = new Activity();
            activity.index = i + 1;
            activity.startTime = scn.nextInt();
            activities.add(activity);
        }
        for (int i = 0; i < len; i++) {
            activities.get(i).finishTime = scn.nextInt();
        }
        return activities;
    }
}

class Activity implements Comparable<Activity> {
    int index;
    int startTime;
    int finishTime;

    @Override
    public int compareTo(Activity o) {
        return Integer.compare(this.finishTime, o.finishTime);
    }
}
