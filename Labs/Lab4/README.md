# CSI 2110: Lab 4 - Min/Max Heaps

## Solution Overview

This repository contains my solution for Lab 4 of the CSI 2110 course, which focuses on implementing Min and Max Heaps using array-based binary trees. Key tasks included implementing core heap operations such as `insert`, `removeMin`, and `removeMax`, as well as managing heap properties through `upheap` and `downheap` functions.

---

## Key Implementations

### 1. Heap Operations in HeapPriorityQueue.java
The following functions were implemented to manage the heap's priority queue:

- **`insert(K key, V value)`**: Inserts a new entry into the heap. It places the new entry at the end of the array, calls `upheap` to maintain the heap order, and increments the array tail.
- **`min()`**: Returns the minimal element (for a min heap) or maximal element (for a max heap) without removing it, which is located at index 0 of the array.
- **`removeMin()` / `removeMax()`**: Removes and returns the minimal (or maximal) element at the root. Replaces the root with the last element, sets the last position to `null`, and calls `downheap` to restore the heap property.

> **Heap Structure**: In the underlying array (0-indexed), the parent of a node at index `i` is located at index `floor((i-1)/2)`, with the left and right children located at `2*i + 1` and `2*i + 2`, respectively.

### 2. Upheap and Downheap Operations
These fundamental operations are essential for maintaining heap order:

- **`upheap(int i)`**: Compares the node at index `i` with its parent and swaps them if the heap property is violated. The function is called recursively on the parent's index until the heap property is restored or the root is reached.
  - **Complexity**: O(log n), as it traverses up a single path in the tree.
- **`downheap(int i)`**: Ensures the heap property from a given index down to the leaves. It checks for children, compares values, and swaps with the largest (for max heap) or smallest (for min heap) child if necessary, calling `downheap` recursively on the swapped child.
  - **Complexity**: O(log n), as it traverses down a single path.

> **Heap Property**: In a max heap, the parent’s key is always greater than or equal to its children, while in a min heap, the parent's key is less than or equal to its children.

---

## Testing the Heap
To validate the implementation, I used `HeapPriorityQueueTest.java`, which includes a variety of test cases to ensure that insertion, deletion, and heap order are maintained correctly. 

1. **Test Setup**:
   - Download the lab files, including `HeapPriorityQueue.java` and `HeapPriorityQueueTest.java`.
   - Compile all files using `javac *.java`.

2. **Run Tests**:
   - Run `HeapPriorityQueueTest.java` to verify that the implemented functions work as expected for both Min and Max heaps.

---

## Example Usage

Here’s an example output when running `HeapPriorityQueueTest.java`:

```plaintext
Inserting elements into the heap...
Heap after insertions: [2, 3, 5, 7, 10]
Minimum element: 2
Removing minimum element...
Heap after removal: [3, 5, 7, 10]

Done by Mohamed Boudabbous
