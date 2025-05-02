import java.util.Scanner;

public class Berkeley {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input number of processes (including master)
        System.out.print("Enter number of processes (including master): ");
        int n = input.nextInt();
        int[] clocks = new int[n];

        // Input clock times for each process
        System.out.println("Enter current clock time (in seconds) for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + i + ": ");
            clocks[i] = input.nextInt();
        }

        int master = clocks[0]; // Assume process 0 is the master
        int totalDiff = 0;

        // Calculate total time difference (excluding master)
        for (int i = 1; i < n; i++) {
            totalDiff += clocks[i] - master;
        }

        // Compute average adjustment (excluding master)
        int avgAdjustment = totalDiff / (n - 1);

        System.out.println("\nMaster clock: " + master + " seconds");
        System.out.println("Average adjustment: " + avgAdjustment + " seconds\n");

        // Adjust each clock
        for (int i = 0; i < n; i++) {
            int offset = (i == 0) ? avgAdjustment : (avgAdjustment - (clocks[i] - master));
            clocks[i] += offset;
            System.out.println("Process " + i + " new time: " + clocks[i] + " seconds");
        }

        input.close();
    }
}
