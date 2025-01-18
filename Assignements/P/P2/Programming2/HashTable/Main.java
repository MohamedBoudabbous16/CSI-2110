import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    private int L;// Ferry length in centimeters
    private ArrayList<Integer> carLengths;// List of car lengths in centimeters
    private Hashtable<String, Boolean> memo;// Hash table for memoization
    private int bestK;//Maximum possible numbers of cars that can be loaded
    private int[] bestX;// Array to store the optimal car placement

    /**
     * Constructor to initialize the ferry length, car lengths, and data structures.
     *
     * @param L          The length of the ferry in centimeters.
     * @param carLengths The list of car lengths in centimeters.
     */
    public Main(int L, ArrayList<Integer> carLengths) {
        this.L = L;
        this.carLengths = carLengths;
        this.memo = new Hashtable<>();
        this.bestK = 0;
        this.bestX = new int[carLengths.size()];
    }
    /**
     * Starts the process of solving the Ferry Loading problem using backtracking.
     */
    public void solve() {
        backtrack(0, L, 0, new int[carLengths.size()]);
    }
    /**
     * Recursive function to explore all possible placements of cars on the ferry using backtracking.
     *
     * @param index           of the current car being considered.
     * @param portRemaining   remaining space on the port (left) side of  ferry.
     * @param starboardUsed  The space already used on the starboard right of the ferry.
     * @param currX          track the current placement of cars.
     */
    private void backtrack(int index, int portRemaining, int starboardUsed, int[] currX) {
        if (index > bestK) {
            bestK = index;
            System.arraycopy(currX, 0, bestX, 0, index);
        }

        if (index >= carLengths.size()) return;

        String stateKey = index + "," + portRemaining + "," + starboardUsed;

        if (memo.containsKey(stateKey)) return;

        memo.put(stateKey, true);

        int carLength = carLengths.get(index);

        if (portRemaining >= carLength) {
            currX[index] = 1;
            backtrack(index + 1, portRemaining - carLength, starboardUsed, currX);
        }

        if (starboardUsed + carLength <= L) {
            currX[index] = 0;
            backtrack(index + 1, portRemaining, starboardUsed + carLength, currX);
        }
    }

    /**
     * Prints the solution: the maximum number of cars
     * loaded and their placements on the ferry.
     */
    public void printSolution() {
        System.out.println(bestK);
        for (int i = 0; i < bestK; i++) {
            System.out.println(bestX[i] == 1 ? "port" : "starboard");
        }
    }

    /**
     * Entry point of the program. Handles input parsing,
     * invokes the solution, and outputs results.
     *
     * @param args Command-line arguments (not used).
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

        scanner.close();
    }
}

