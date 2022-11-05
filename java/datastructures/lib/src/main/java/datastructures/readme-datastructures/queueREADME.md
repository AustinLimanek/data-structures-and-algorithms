# Queue

[Implementation Code](../queue/Queue.java)

[Testing Code](../../../../test/java/datastructures/queue/QueueTest.java)

## Challenge

Create a linked list data type by defining two classes. First, Node which will take a value on construction and has a parameter called next that is of datatype Node. This means that Node is a self-referential class. On instantiation a new node should point to null. Second, LinkedList which will have a parameter with data type node called head, which will be the starting location of the list. Methods should be in the LinkedList class.

## Features

- [x] insert: adds a new node with a value in O(1) time
- [x] includes: searches a linkedlist for a specified value -> returns boolean [Time: O(n), Space: O(1)]
- [x] toString: converts the linkedlist into a string of the form "{ e1 } -> { e2 } -> { e3 } -> null" [Time: O(n), Space: O(1)]
- [x] endAppend: adds a new node to a linked list with a given value [Time: O(n), Space: O(1)]
- [x] insertBefore: adds a new node with a given value before the first node in a linked list that has a given relative value [Time: O(n), Space: O(1)]
- [x] insertAfter: adds a new node with a given value after the first node in a linked list that has a given relative value [Time: O(n), Space: O(1)]
- [x] size: return the number of nodes in a linked list [Time: O(n), Space: O(1)]
- [x] nthValue: input: `int`. returns the value of the nth (starting from 0) node in the linked list [Time: O(n), Space: O(1)]
- [x] kthFromEnd: input `int`. return the value of the kth (starting from 0 -> tail) node of the linked list [Time: O(n), Space: O(1)]
- [x] midNodeValue: returns the value of a central node. Mid is the middle of an odd sized linked list and mid is the right central node in an even sized linked list [Time: O(n), Space: O(1)]

## Specifications & Tests
