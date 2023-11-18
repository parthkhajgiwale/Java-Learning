import java.util.Arrays;
import java.util.Scanner;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int priority;

    Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class PriorityScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of processes from the user
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        Process[] processes = new Process[n];

        // Get details for each process from the user
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            System.out.print("  Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("  Burst Time: ");
            int burstTime = scanner.nextInt();
            System.out.print("  Priority: ");
            int priority = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime, priority);
        }

        scanner.close();

        // Call the Priority scheduling algorithm
        priorityScheduling(processes);
    }

    // Implementation of Priority Scheduling algorithm
    public static void priorityScheduling(Process[] processes) {
        int n = processes.length;

        Arrays.sort(processes, (a, b) -> Integer.compare(a.priority, b.priority));

        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] completionTime = new int[n];

        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            Process currentProcess = processes[i];
            completionTime[currentProcess.id - 1] = currentTime + currentProcess.burstTime;
            turnaroundTime[currentProcess.id - 1] = completionTime[currentProcess.id - 1] - currentProcess.arrivalTime;
            waitingTime[currentProcess.id - 1] = turnaroundTime[currentProcess.id - 1] - currentProcess.burstTime;

            currentTime = completionTime[currentProcess.id - 1];
        }

        // Print results
        System.out.println("Process\t Arrival Time\t Burst Time\t Priority\t Completion Time\t Waiting Time\t Turnaround Time");
        for (int i = 0; i < n; i++) {
            Process currentProcess = processes[i];
            System.out.println(currentProcess.id + "\t\t" + currentProcess.arrivalTime + "\t\t\t" +
                    currentProcess.burstTime + "\t\t\t" + currentProcess.priority + "\t\t\t" +
                    completionTime[currentProcess.id - 1] + "\t\t\t" + waitingTime[currentProcess.id - 1] +
                    "\t\t\t" + turnaroundTime[currentProcess.id - 1]);
        }
    }
}
