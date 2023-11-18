import java.util.ArrayList;
import java.util.Scanner;

// Class representing a process
class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    // Constructor to initialize process attributes
    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.completionTime = -1; // Initialize to -1 to indicate not completed
        this.turnaroundTime = -1; // Initialize to -1 to indicate not calculated
        this.waitingTime = -1;    // Initialize to -1 to indicate not calculated
    }
}

// Main class
public class SJFPreemptive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        // ArrayList to store the processes
        ArrayList<Process> processes = new ArrayList<>();

        // Input: Arrival time and Burst time for each process
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for process P" + i + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter burst time for process P" + i + ": ");
            int burstTime = scanner.nextInt();

            processes.add(new Process(i, arrivalTime, burstTime));
        }

        int currentTime = 0;
        int completedProcesses = 0;

        // SJF Preemptive Scheduling Algorithm
        while (completedProcesses < n) {
            Process shortestProcess = null;
            int shortestBurstTime = Integer.MAX_VALUE;

            // Find the process with the shortest remaining burst time
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime < shortestBurstTime && p.remainingTime > 0) {
                    shortestProcess = p;
                    shortestBurstTime = p.remainingTime;
                }
            }

            if (shortestProcess != null) {
                // Execute the process for 1 unit of time
                System.out.println("Executing P" + shortestProcess.id + " at time " + currentTime);
                shortestProcess.remainingTime--;

                if (shortestProcess.remainingTime == 0) {
                    // Process completed
                    completedProcesses++;
                    shortestProcess.completionTime = currentTime + 1;
                    System.out.println("P" + shortestProcess.id + " completed at time " + shortestProcess.completionTime);
                }
            }

            currentTime++;
        }

        // Calculate turnaround time and waiting time for each process
        for (Process p : processes) {
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
        }

        // Print results
        System.out.println("\nProcess\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.println(p.id + "\t" + p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }

        // Close the scanner
        scanner.close();
    }
}
