import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class JobScheduler {
    public static void main(String[] args) {
        System.out.println("Enter the number of Jobs");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new Job(start, end, profit));

        }

        // Sort jobs in decreasing order of profit
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Lokesh's selected jobs
        List<Job> selectedJobs = new ArrayList<>();
        int lastEndTime = 0;
        for (Job job : jobs) {
            if (job.start >= lastEndTime) {
                selectedJobs.add(job);
                lastEndTime = job.end;
            }
        }
        // Remaining jobs
        List<Job> remainingJobs = new ArrayList<>(jobs);
        remainingJobs.removeAll(selectedJobs);

        // Print results
        System.out.println("The number of tasks and earnings available for others");
        System.out.println("Tasks: " + remainingJobs.size());
        int totalEarnings = remainingJobs.stream().mapToInt(j -> j.profit).sum();
        System.out.println("Earnings: " + totalEarnings);
    }
}
