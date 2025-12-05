25_11_Assignments

1.Implement Insertion Sort

2.Implement Linear Queue using Array that includes operations like:
  enqueue,dequeue,isFull,isEmpty,peek.
  Also display the contents of the queue.
  Enqueue and Dequeue multiple times to check the contents of the queue.

3.Implement Circular Queue using Array that includes operations like:
  enqueue,dequeue,isFull,isEmpty,peek.
  Also display the contents of the queue.
  Enqueue and Dequeue multiple times to check the contents of the circular 
  queue.

4.Reverse First K Elements of a Queue


--------------------------------------------------
Problem Statement:
Given a queue of integers and a number k, reverse the order of the first k elements of the queue, leaving the remaining elements in the same relative order.
--------------------------------------------------
Description:
You need to implement a function that takes a queue and an integer k as input, and reverses only the first k elements while keeping the rest of the queue unchanged.

Example 1:
Input Queue: [10, 20, 30, 40, 50, 60, 70]
k = 4

Output Queue: [40, 30, 20, 10, 50, 60, 70]

Explanation: 
First 4 elements [10, 20, 30, 40] are reversed to [40, 30, 20, 10]
Remaining elements [50, 60, 70] stay in the same order

Example 2:
Input Queue: [5, 10, 15, 20, 25]
k = 3

Output Queue: [15, 10, 5, 20, 25]

Explanation:
First 3 elements are reversed, last 2 remain unchanged
------------------------------------------------------------

5: Generate First N Binary Numbers

Problem Statement:
Generate and print the first N binary numbers (in increasing order) starting from 1.

Description:
You need to implement a function that prints the binary representations of numbers from 1 to N. 

Example 1:
Input: N = 5

Output: 
1
10
11
100
101

Explanation: Binary representations of 1, 2, 3, 4, 5
Example 2:
Input: N = 10

Output:
1
10
11
100
101
110
111
1000
1001
1010

Explanation: Binary representations of 1 through 10


Hint:
The efficient solution uses a queue data structure to generate binary 
numbers in sequence. Each binary number is generated from the previous 
ones by appending '0' and '1'.