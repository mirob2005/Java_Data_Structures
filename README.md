Java_Data_Structures
====================

## *ADTS:*
- Queue with only head ptr, remove old at head, append new to the end
- Stack (push/pop at head)
- Priority Queue (uses an array-based Binary Heap)

## *Binary Heap Operations:*
- traverseBFS
- insert (with heapifyUp to ensure heap property)
- delete (with heapifyDown to ensure heap property)
- peek (get max value)
- copyHeap

### *Types:*
- Array Structure

JUnits Tests to test each operation and to ensure proper tracking
of next insert/delete location to ensure shape property

## *Binary Search Tree Operations:*
- add - recursive
- find - recursive
- delete - recursive
- traverseBFS - iterative (uses a queue)
- traverseDFSpreorder - recursive
- traverseDFSinorder - recursive
- traverseDFSpostorder - recursive
- copyTree - recursive
- deleteTree - recursive
- findMin - iterative
- findMax - iterative

## *Hash Table Operations:*
- add
- updateValue
- delete
- deleteAll
- lookUp
- getHash

### *Types:*
- Separate Chaining Collision resolution using ArrayLists

## *Graphs:*
### *Adjacency List:*
- Use: Run Graphs to run a sample adjacency list with outputs of the different operations.
- Vertices are stored in an arraylist. Each vertex has an arraylist of edges to neighoring vertices. 
- Supports directed graphs.

*Operations:*
- addVertex
- addEdge
- removeVertex
- removeEdge
- updateEdge
- copyGraph
- deleteGraph

*Implemented Algorithms:*

*Breadth First Search*
- traverseBFS
- shortestPath

*Depth First Search*
- DAG test
- traverseDFS
- topological sort
- Classification of edges into (in comments): 
1)Tree Edges 
2)Back Edges 
3)Forward/Cross Edges

## *Sorting:*
### Run Sorting to run all implemented sorting methods.
### Merge Sorts:
### MergeSort:
- not in place, stable sort
- O(n log n) best/AVG/worst case performance
- O(n) auxiliary space

### Exchange Sorts:
### QuickSort:
- not in place, not stable
- O(n log n) best/AVG, O(n^2) worst case performance
- O(n) auxiliary space
- fastest on average

### Insertion Sorts:
### Insertion Sort:
- stable, in-place
- O(n^2) - worst/AVG case, O(n) - best case (already sorted list)
- O(1) auxilary - worst case space complexity

