package Practice.Greedy.JobSchedulingForMaxProfit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JobSchedulingForMaxProfit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int size = scn.nextInt();
            List<Job> jobs = readJobs(scn, size);
            printMaxProfitSchedule(jobs);
        }
    }

    private static void printMaxProfitSchedule(List<Job> jobs) {
        Collections.sort(jobs);
        int jobLen = jobs.size();
        Job[] schedule = new Job[jobLen];
        for (Job curJob : jobs) {
            for (int j = Math.min(jobLen, curJob.deadLine) - 1; j >= 0; j--) { // notice -1 after Math.min
                if (schedule[j] == null) {
                    schedule[j] = curJob;
                    break;
                }
            }
        }
        int jobCount = 0, profit = 0;
        for (Job job : schedule) {
            if (job != null) {
                jobCount++;
                profit += job.profit;
            }
        }
        System.out.println(jobCount + " " + profit);
    }

    private static List<Job> readJobs(Scanner scn, int size) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Job job = new Job();
            job.id = scn.nextInt();
            job.deadLine = scn.nextInt();
            job.profit = scn.nextInt();
            jobs.add(job);
        }
        return jobs;
    }
}

class Job implements Comparable<Job> {
    int id;
    int deadLine;
    int profit;

    @Override
    public int compareTo(Job o) {
        return Integer.compare(o.profit, this.profit);
    }
}
