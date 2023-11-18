import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Process {
    int id;
    int arrivalTime;
    int burstTime;

    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of processes from the user
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] processIds = new int[n];
        int[] arrivalTimes = new int[n];
        int[] burstTimes = new int[n];

        // Get details for each process from the user
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            System.out.print("  Arrival Time: ");
            arrivalTimes[i] = scanner.nextInt();
            System.out.print("  Burst Time: ");
            burstTimes[i] = scanner.nextInt();
            processIds[i] = i + 1;
        }

        // Get the time quantum from the user
        System.out.print("Enter the time quantum: ");
        int timeQuantum = scanner.nextInt();

        scanner.close();

        // Call the Round Robin scheduling algorithm
        roundRobin(processIds, arrivalTimes, burstTimes, timeQuantum);
    }

    // Implementation of the Round Robin scheduling algorithm
    public static void roundRobin(int[] processIds, int[] arrivalTimes, int[] burstTimes, int timeQuantum) {
        int n = processIds.length;

        Queue<Process> queue = new LinkedList<>();
        int[] remainingBurstTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];
        int[] completionTime = new int[n];

        // Initialize data structures and add processes to the queue
        for (int i = 0; i < n; i++) {
            remainingBurstTime[i] = burstTimes[i];
            queue.add(new Process(processIds[i], arrivalTimes[i], burstTimes[i]));
        }

        int currentTime = 0;

        // Execute processes in the queue using Round Robin
        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            int executeTime = Math.min(remainingBurstTime[currentProcess.id - 1], timeQuantum);

            // Update waiting time for processes which have arrived
            for (int i = 0; i < n; i++) {
                if (arrivalTimes[i] <= currentTime && i + 1 != currentProcess.id) {
                    waitingTime[i] += executeTime;
                }
            }

            currentTime += executeTime;
            remainingBurstTime[currentProcess.id - 1] -= executeTime;

            // Add back to the queue if burst time is remaining, else calculate turnaround time
            if (remainingBurstTime[currentProcess.id - 1] > 0) {
                queue.add(currentProcess);
            } else {
                completionTime[currentProcess.id - 1] = currentTime;
                turnaroundTime[currentProcess.id - 1] = currentTime - arrivalTimes[currentProcess.id - 1];
            }
        }

        // Print results
        System.out.println("Process\t Arrival Time\t Burst Time\t Completion Time\t Waiting Time\t Turnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processIds[i] + "\t\t" + arrivalTimes[i] + "\t\t\t" + burstTimes[i] + "\t\t\t" +
                    completionTime[i] + "\t\t\t" + waitingTime[i] + "\t\t\t" + turnaroundTime[i]);
        }
    }
}
