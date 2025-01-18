import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private int L;// Ferry length
    private ArrayList<Integer> carLengths;// List of car lengths
    private int bestK; //Maximum possible numbers of cars that can be loaded
    private int[] currX, bestX;// Arrays to track the
    // current and the best placement of cars
    private boolean[][] visited;// Memoization table

    /**
     * Constructor to initialize the ferry length, car lengths, and data structures.
     *
     * @param L          The length of the ferry in centimeters.
     * @param carLengths The list of car lengths.
     */
    public Main(int L, ArrayList<Integer> carLengths) {
        this.L = L;
        this.carLengths = carLengths;
        this.bestK = 0;
        this.currX = new int[carLengths.size()];
        this.bestX = new int[carLengths.size()];
        this.visited = new boolean[carLengths.size() + 1][L + 1];
    }

    /**
     * Starts the process of solving the Ferry Loading problem using backtracking.
     */
    public void solve() {
        backtrack(0, L, 0);
    }

    /**
     * Recursive function that implements the backtracking algorithm to explore all possible
     * arrangements of cars on the ferry.
     *
     * @param currK The number of cars considered so far.
     * @param currS The remaining space on the port (left) side of the ferry.
     * @param currR The used space on the starboard (right) side of the ferry.
     */
    private void backtrack(int currK, int currS, int currR) {
        if (currK > bestK) {
            bestK = currK;
            System.arraycopy(currX, 0, bestX, 0, currK);
        }

        if (currK >= carLengths.size()) return;

        int carLength = carLengths.get(currK);

        if (currS >= carLength && !visited[currK + 1][currS - carLength]) {
            visited[currK + 1][currS - carLength] = true;
            currX[currK] = 1;
            backtrack(currK + 1, currS - carLength, currR);
        }

        if (currR + carLength <= L && !visited[currK + 1][currS]) {
            visited[currK + 1][currS] = true;
            currX[currK] = 0;
            backtrack(currK + 1, currS, currR + carLength);
        }
    }

    /**
     * Prints the solution: the maximum number of cars loaded and their placements on the ferry.
     */
    public void printSolution() {
        System.out.println(bestK);
        for (int i = 0; i < bestK; i++) {
            System.out.println(bestX[i] == 1 ? "port" : "starboard");
        }
    }
    /**
     * Entry point of the program that handles input and output for multiple test cases.
     *
     * @param args Command-line arguments .
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        scanner.nextLine();

        while (numTests-- > 0) {
            int L = scanner.nextInt() * 100;
            ArrayList<Integer> carLengths = new ArrayList<>();

            while (true) {
                int carLength = scanner.nextInt();
                if (carLength == 0) break;
                carLengths.add(carLength);
            }

            Main solver = new Main(L, carLengths);
            solver.solve();
            solver.printSolution();

            if (numTests > 0) System.out.println();
        }
    }
}
