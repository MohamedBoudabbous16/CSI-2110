# CSI 2110: Lab 1 - Part 2 - Algorithm Analysis Solution

## Solution Overview

This repository contains my solution for Part 2 of Lab 1 in the CSI 2110 course, focusing on the analysis of algorithm complexities. The main tasks involved implementing timing functions to analyze the performance of duplicate detection algorithms and comparing the runtime of various sorting and checking approaches.

---

## Key Implementations

### 1. Duplicate Detection (unique1Runtime and unique2Runtime)
In the `AlgAnalysis.java` class, I implemented the following methods:

- **`unique1Runtime(int n)`**: Generates a random array and times the execution of the `Unique1.unique1` algorithm, which checks for duplicates using a brute-force approach with O(n²) complexity.
- **`unique2Runtime(int n)`**: Generates a random array and times the execution of the `Unique2.unique2` algorithm, which checks for duplicates by sorting the array first (average complexity O(n log n)).

> **Performance Note**: The `unique2` method, by leveraging sorting, performs more efficiently on average than `unique1`, especially for larger arrays.

### 2. Sorting Runtime Analysis (arraySortRuntime)
This function evaluates the time taken by Java's `Arrays.sort()` method on arrays of various sizes, incremented in steps based on `maxSize / count`:
- **Prints `minTime / (i^2)`**: This value approaches 0 as `i` increases, suggesting sub-quadratic performance.
- **Prints `minTime / (i * log2(i))`**: This value approaches a constant, confirming the expected O(n log n) complexity for sorting.

---

## Observations on Algorithm Complexity

### Unique1 Algorithm (unique1.java)
- This brute-force approach has an O(n²) complexity, making it slower for large arrays.

### Unique2 Algorithm (unique2.java)
- The use of sorting enables an average-case complexity of O(n log n) for detecting duplicates, which is significantly faster than `unique1` for large inputs.

---

## Common Challenges
- **Time Measurement**: Ensuring accurate runtime measurements using `System.nanoTime()` to capture the performance of each function.
- **Handling Large Arrays**: Generating and sorting large arrays requires careful memory management and can be time-intensive for `unique1`.

---

## How to Run the Code
1. Clone this repository.
2. Open the project in your Java IDE (IntelliJ IDEA recommended).
3. Run the `AlgAnalysis.java` main methods to analyze the runtimes for each approach.

Done by Mohamed Boudabbous
