# CSI 2110: Lab 2 - Stack Implementations and Applications

## Solution Overview

This repository contains my solution for Lab 2 of the CSI 2110 course, focusing on stack implementations using arrays and linked lists, as well as applications of stacks for array reversal and balanced bracket checking.

---

## Key Implementations

### 1. Array-Based Stack (ArrayStack.java)
Implemented a stack using an array structure to perform standard stack operations:
- **`push(E e)`**: Adds an element to the top of the stack, increasing the stack size by 1.
- **`pop()`**: Removes and returns the top element of the stack, decreasing the stack size by 1.
- **`top()`**: Returns the top element without removing it.
- **`getSize()`** and **`isEmpty()`**: Check the stack’s size and whether it is empty.

### 2. Linked List-Based Stack (LinkedStack.java)
Implemented a stack using a singly linked list with a head pointer:
- **`push(E e)`**: Adds a new head node, linking it to the previous head.
- **`pop()`**: Removes and returns the head element, updating the head to the next node.
- **`top()`**: Returns the head element without removing it.

> **Performance Note**: The linked list stack avoids the fixed capacity issue but can grow dynamically with memory limitations.

### 3. Array Reversal Using Stack (TryStack1.java and TryStack2.java)
The goal here was to reverse an array using a stack by:
- **Pushing** each element of the array into a stack.
- **Popping** each element from the stack to reconstruct the array in reverse order.

> **Result**: Both `ArrayStack` and `LinkedStack` implementations successfully reverse the array.

### 4. Balanced Bracket Checker (BracketsBalance.java)
Implemented the `isBalanced(String exp)` function to check if brackets in a string are balanced:
- **Push** each opening bracket into a stack.
- **Pop** the stack when encountering a closing bracket and verify if it matches the corresponding opening bracket.
- Return `true` if all brackets are matched and the stack is empty at the end; otherwise, return `false`.

> **Result**: The function successfully verifies balanced brackets and provides accurate results for well-formed and unbalanced expressions.

---

## Observations on Stack Implementations

### Array-Based Stack
- Simple and efficient but limited by a fixed size.
- Requires array resizing or an error handling strategy if capacity is exceeded.

### Linked List-Based Stack
- Dynamically grows with each push, limited by system memory.
- Eliminates the need for resizing and handles large inputs efficiently.

---

## How to Run the Code

1. **Download and Setup**:
   - Download `lab2.zip` and extract the contents.
   - Open the `/stack` and `/balance` folders in your Java IDE.

2. **Compile**:
   - Compile all files using `javac *.java` or individually as needed.

3. **Run Array Reversal**:
   - Run `TryStack1.java` to reverse an array using `ArrayStack`.
   - Complete and run `TryStack2.java` to reverse an array using `LinkedStack`.

4. **Run Balanced Bracket Checker**:
   - Open `BracketsBalance.java` in your editor and implement test cases.
   - Run the program with sample expressions to check for balanced brackets.

---

## Sample Test Cases

**Balanced Brackets**
[1 + 1] + (2 + 2) + {4 + 3} ➔ Balanced
( { [ x + 1 ] * 2 } / ( 2 + a ) ) ➔ Balanced
**Unbalanced Brackets**
([1 + 1] + (2 + 2))( ➔ Not balanced
([1 + 1] + (2 + 2))} ➔ Not balanced
[1 + 1} + (2 + 2) + {4 + 3} ➔ Not balanced

