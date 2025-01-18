# CSI 2110: Lab 5 - Binary Search Tree Traversal Approaches

## Solution Overview

This repository contains my solution for Lab 5 of the CSI 2110 course, which focuses on implementing recursive traversal methods for a Binary Search Tree (BST) and building iterators for in-order and pre-order traversals. Key tasks included implementing recursive functions for each traversal approach and completing iterator methods.

---

## Key Implementations

### 1. Recursive Traversal Methods in LinkedBinarySearchTree.java
The following traversal methods were implemented recursively to navigate the BST:

- **`preorderRecursive(Node<E> curr)`**: Visits the current node, then traverses the left and right subtrees. This results in a **pre-order traversal** (Current, Left, Right).
- **`inorderRecursive(Node<E> curr)`**: Traverses the left subtree, visits the current node, and then traverses the right subtree. This results in an **in-order traversal** (Left, Current, Right).
- **`postorderRecursive(Node<E> curr)`**: Traverses the left and right subtrees, then visits the current node. This results in a **post-order traversal** (Left, Right, Current).

> **Traversal Examples**: For a sample BST, different traversal orders would yield unique sequences of node visits, as demonstrated below.

---

## Example Traversal Orders

Given the following BST structure:

```plaintext
        10
       /    \
      6     12
     / \    / \
    5   7  11  13
    Pre-Order: 10, 6, 5, 7, 12, 11, 13
    In-Order: 5, 6, 7, 10, 11, 12, 13
    Post-Order: 5, 7, 6, 11, 13, 12, 10

2. In-Order and Pre-Order Iterators

In LinkedBinarySearchTree.java, I implemented custom iterators for in-order and pre-order traversals. These iterators allow traversing the tree without using recursion by leveraging Java’s Iterator interface.

    In-Order Iterator (InOrderIterator):
        next(): Returns the next element in in-order sequence. It moves left as far as possible, then visits the right or climbs up the tree to find the next node.
        Cases:
            If there’s a right child, go right, then left as much as possible.
            If no right child, climb up until coming from the left.

    Pre-Order Iterator (PreOrderIterator):
        next(): Returns the next element in pre-order sequence. It visits the current node, then tries to go left, then right, or climbs up if no children are available.
        Cases:
            Visit the left child if available.
            Visit the right child if no left child is available.
            If no left or right child, climb up until a right child is found or the root is reached.

How to Run the Code

    Download and Setup:
        Download lab5.zip and extract the files.
        Open the folder in your Java IDE.

    Implement and Test:
        Complete the recursive traversal functions in LinkedBinarySearchTree.java.
        Implement the missing next() methods for InOrderIterator and PreOrderIterator.
        Run BSTTraversalTest.java to validate traversal outputs for each method.

Example Output

Running BSTTraversalTest.java yields traversal results for a sample BST, confirming the correct sequence of nodes visited in each order:
Pre-Order Traversal: 10, 6, 5, 7, 12, 11, 13
In-Order Traversal: 5, 6, 7, 10, 11, 12, 13
Post-Order Traversal: 5, 7, 6, 11, 13, 12, 10

Common Challenges

    Iterator Logic: Implementing next() in both InOrderIterator and PreOrderIterator required careful handling of tree traversal without recursion.
    Parent-Child Relationships: Ensuring proper handling of left and right children, especially when climbing back up the tree, was essential to maintain traversal order.

Additional Resources

    Textbook: Goodrich, Tamassia, and Goldwasser, Data Structures and Algorithms in Java, 6th edition.
        Chapter 10: Trees and Traversals

License

This project is intended for educational use.

Done by Mohamed Boudabbous

