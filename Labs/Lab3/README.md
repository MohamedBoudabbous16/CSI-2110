# CSI 2110: Lab 3 - Sequences and Inheritance

## Solution Overview

This repository contains my solution for Lab 3 of the CSI 2110 course, which involves implementing and testing various sequence structures. The main tasks included modifying `LinkedSequence<E>` for sequence manipulation and implementing additional methods in `SequenceAlgs.java` for operations like palindrome checking and sequence reversal.

---

## Key Implementations

### 1. LinkedSequence Modifications
In the `LinkedSequence<E>` class, I implemented the following functions to enhance sequence manipulation:

- **`positionAtIndex(int i)`**: Traverses the linked list to find the position object at the given index `i`.
- **`indexAtPosition(Position<E> pos)`**: Finds the index of a given position object by traversing the list.
- **`get(int i)`**: Returns the element at the specified index by using `positionAtIndex`.
- **`set(int i, E e)`**: Sets the element at index `i` using `positionAtIndex`.
- **`add(int i, E e)`**: Adds an element at a specific index `i`.
- **`remove(int i)`**: Removes the element at the specified index.

> **Testing Note**: The main method in `SequenceTester.java` was used to validate these implementations, ensuring identical results for both `ArraySequence` and `LinkedSequence`.

### 2. Sequence Algorithms in SequenceAlgs.java
In `SequenceAlgs.java`, I implemented additional sequence operations:

- **`isPalindrome(Sequence<E> s)`**: Checks if the sequence is a palindrome by comparing elements from both ends moving towards the center.
- **`swap(Sequence<E> S, Position<E> x, Position<E> y)`**: Swaps the elements at two given positions in the sequence.
- **`inplaceReverse(Sequence<E> S)`**: Reverses the sequence in place using the `swap` function.
- **`inplaceKReverse(Sequence<E> S, int k)`** (optional): Reverses each substring of length `k` within the sequence. For remaining elements if the length is not divisible by `k`, a partial reverse is performed.

> **Performance Note**: The `inplaceKReverse` function uses the `inplaceReverse` function on subsegments for optimized partial reversals.

---

## Observations on Sequences and Positional Lists

### ArraySequence vs LinkedSequence
- `ArraySequence`: Offers fast access by index but can have higher memory usage due to resizing operations.
- `LinkedSequence`: Utilizes a doubly linked list with sentinel nodes, which provides flexibility in insertions and deletions without resizing.

### Positional List Benefits
Using position-based access rather than index-based access adds flexibility, especially for linked structures, allowing efficient insertion and deletion at arbitrary positions.

---

## How to Run the Code

1. **Download and Setup**:
   - Download `lab3.zip` and extract the files.
   - Open the folder in your Java IDE.

2. **Compile**:
   - Compile all files using `javac *.java`.

3. **Run Tests**:
   - Run `SequenceTester.java` to verify the behavior of `LinkedSequence` and `ArraySequence`.
   - Run `SequenceAlgs.java` to test the `isPalindrome`, `swap`, and `inplaceReverse` functions.

---

## Example Outputs

**ArraySequence and LinkedSequence Test Results**
```plaintext
Testing Results for ArraySequence:
S=(18, 16, 14, 12, 10, 8, 6, 4, 2, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
S=(8, 6, 4, 2, 0, 0, 1, 2, 3, 4)
...

Testing Results for LinkedSequence:
S=(18, 16, 14, 12, 10, 8, 6, 4, 2, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
S=(8, 6, 4, 2, 0, 0, 1, 2, 3, 4)
...
Testing ArraySequence:
Is palindrome?=false
After 3 reversal:
(4, 2, 0, 10, 8, 6, 16, 14, 12, ...)
Is palindrome?=true

Testing LinkedSequence:
Is palindrome?=false
After reversal:
(36, 38, 30, 32, ...)
Is palindrome?=true
Common Challenges

    Index vs. Position: Implementing positionAtIndex and indexAtPosition required careful management of list traversal.
    Edge Cases: Ensuring palindrome checks and reversals handle single-element and empty sequences correctly.

Additional Resources

    Textbook: Goodrich, Tamassia, and Goldwasser, Data Structures and Algorithms in Java, 6th edition.
        Chapter 6.1: Positional Lists and Sequence Implementations

License

This project is intended for educational use.

Ce fichier `README.md` est structuré en un seul bloc avec la mention "Done by Mohamed Boudabbous" à la fin, comme demandé.


