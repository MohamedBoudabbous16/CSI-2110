 CSI 2110: Lab 1 - Linked Lists Solution

## Solution Overview

This repository contains my solution for Lab 1 of the CSI 2110 course, which focuses on singly and doubly linked lists. The main tasks involved implementing specific functions within a doubly linked list structure and comparing its performance with a singly linked list.

---

## Key Implementations

### 1. Doubly Linked List (DLinkedList.java)
In the `DLinkedList.java` class, I implemented the following methods:

- **`print()`**: This method iterates through the nodes and prints out the data in each node in sequence.
- **`deleteFirst()`**: Deletes the first element in the doubly linked list by adjusting the head node's references. This operation has an O(1) time complexity.
- **`deleteLast()`**: Deletes the last element by updating the tail node's references, also in O(1) time.

> **Performance Note**: The doubly linked list benefits from having both `previous` and `next` references, allowing for efficient deletions and insertions at both ends of the list.

### 2. Performance Comparison
In the main methods of both `LinkedList` (singly linked list) and `DLinkedList` (doubly linked list), I executed identical operations to observe the difference in execution times.

- **Result**: As expected, the doubly linked list performed faster than the singly linked list, especially for operations involving the tail node. The singly linked list required traversal to access the last element, resulting in O(N) time complexity, whereas the doubly linked list performed such operations in O(1) time.

---

## Observations on Linked List Structures

### Singly Linked List (LinkedList.java)
- The singly linked list has no tail node and requires traversal for operations on the last element.
- While deletion of the first element is efficient (O(1)), deletion of the last element is O(N) due to the traversal requirement.

### Doubly Linked List (DLinkedList.java)
- With both head and tail dummy nodes, the doubly linked list offers faster insertion and deletion at both ends.
- This structure allows O(1) operations for adding or removing elements from either end of the list, significantly improving performance for these tasks.

---

## Common Challenges
- **Updating Size**: It's important to remember to update the list size after each deletion or insertion.
- **Dummy Nodes**: The dummy head and tail nodes serve as placeholders to simplify edge cases for insertion and deletion operations.

---

## How to Run the Code
1. Clone this repository.
2. Open the project in your Java IDE (IntelliJ IDEA recommended).
3. Run the main methods in both `LinkedList` and `DLinkedList` to observe the performance comparison.
Done by Mohamed Boudabbous