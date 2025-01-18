# CSI 2110: Lab 6 - Balanced Binary Search Trees (AVL Trees)

## Solution Overview

This repository contains my solution for Lab 6 of the CSI 2110 course, which focuses on implementing and analyzing balanced binary search trees (AVL Trees) and comparing them with standard binary search trees (BSTs) in terms of height and efficiency. Key tasks included implementing height calculations in a tree map and simulating random tree generation to observe the structural differences between AVL trees and regular BSTs.

---

## Key Implementations

### 1. Height Calculation in TreeMap (TreeMap.java)
To calculate the height of a binary search tree, I added a recursive function in `TreeMap.java`:

- **`height()`**: Public method that initiates height calculation from the root node.
- **`heightRecurse(Position<Entry<K,V>> node)`**: A tail-recursive helper function that computes the maximum height of the left and right subtrees.
  - **Base Case**: When the node is external, return a height of 0.
  - **Recursive Step**: For each node, return `Math.max(heightRecurse(left), heightRecurse(right)) + 1`.

> **Implementation Note**: The `heightRecurse` method uses `Math.max` to calculate the maximum height of the left and right children, ensuring accurate height calculation for AVL balancing.

### 2. Modifying randomTrees in Verify.java
In `Verify.java`, I modified the `randomTrees` function to generate random AVL and BST structures, updating min, max, and average heights for each set of trees generated:

- **randomTrees(int nTrees, int noNodes)**: 
  - Creates a specified number of AVL and BST trees.
  - For each tree, a loop generates a random integer and inserts it into both the AVL and BST (if it is not already present).
  - After each insertion, `updateCounters()` is used to track the min, max, and average heights for both AVL and BST.
  - The loop iterates over an increasing number of nodes and trees, starting with 2 nodes and 8 trees, doubling nodes, and quadrupling the number of trees in each iteration.

> **Expected Outcome**: The height statistics reveal that AVL trees maintain a lower average height than BSTs, especially noticeable as the number of nodes increases.

---

## Observations on AVL Trees and BSTs

### AVL Trees
- **Balance Property**: AVL trees ensure that for each node, the height difference between left and right subtrees is at most 1. This constraint keeps the tree balanced, achieving an average search complexity of O(log n).
- **Rotations**: To maintain balance, AVL trees may perform rotations after insertions or deletions.

### Binary Search Trees (BSTs)
- **Worst-Case Complexity**: Without balancing, a BST can degrade to a linked list structure in the worst case, resulting in O(n) search complexity.
- **Comparison with AVL**: For large datasets, BSTs typically have a greater height than AVL trees, leading to longer search times.

---

## How to Run the Code

1. **Download and Setup**:
   - Download the associated lab files.
   - Place files in the following structure:
     ```plaintext
     Project/
     ├── Verify.java
     └── net.datastructures/
         ├── TreeMap.java
         └── AVLTreeMap.java
     ```

2. **Modify and Compile**:
   - Implement the `height` method in `TreeMap.java`.
   - Modify `randomTrees` in `Verify.java`.
   - Compile all files using `javac *.java` or `javac net/datastructures/*.java`.

3. **Run Tests**:
   - Run `Verify.java` to generate and compare AVL and BST structures.

---

## Example Output

Sample output from `Verify.java` may look as follows:

```plaintext
Nodes | Trees | Min Height (BST) | Max Height (BST) | Avg Height (BST) | Min Height (AVL) | Max Height (AVL) | Avg Height (AVL)
-------------------------------------------------------------------------------------
2     | 8     | 1               | 2                | 1.5              | 1               | 1                | 1.0
4     | 32    | 2               | 4                | 3.0              | 2               | 3                | 2.1
...
he output should show that AVL trees consistently have lower average heights than BSTs as the number of nodes increases, reflecting AVL’s balancing advantage.
Common Challenges

    Height Calculation: Ensuring accurate height calculation in TreeMap required careful handling of recursion and understanding of base cases.
    Random Insertion: Avoiding duplicate entries in the tree during random insertion was essential to prevent skewed height statistics.

Additional Resources

    Textbook: Goodrich, Tamassia, and Goldwasser, Data Structures and Algorithms in Java, 6th edition.
        Chapter 10: AVL Trees and Tree Balancing

License

This project is intended for educational use.

Done by Mohamed Boudabbous