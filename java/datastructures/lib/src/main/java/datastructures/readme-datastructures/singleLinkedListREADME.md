# Single Linked List

[Implementation Code](../linkedlist)

[Testing Code](../../../../test/java/datastructures/linkedlist/LinkedListTest.java)

## Challenge

Create a linked list data type by defining two classes. First, Node which will take a value on construction and has a parameter called next that is of datatype Node. This means that Node is a self-referential class. On instantiation a new node should point to null. Second, LinkedList which will have a parameter with data type node called head, which will be the starting location of the list. Methods should be in the LinkedList class.

## Features

- [x] insert: adds a new node with a value in O(1) time
- [x] includes: searches a linkedlist for a specified value -> returns boolean [Time: O(n), Space: O(1)]
- [x] toString: converts the linkedlist into a string of the form "{ e1 } -> { e2 } -> { e3 } -> null" [Time: O(n), Space: O(1)]
- [x] endAppend: adds a new node to a linked list with a given value [Time: O(n), Space: O(1)]
- [x] insertBefore: adds a new node with a given value before the first node in a linked list that has a given relative value [Time: O(n), Space: O(1)]
- [x] insertAfter: adds a new node with a given value after the first node in a linked list that has a given relative value [Time: O(n), Space: O(1)]

## Specifications & Tests

### Day 1

- [x] Can successfully instantiate an empty linked list
- [x] Can properly insert into the linked list
- [x] The head property will properly point to the first node in the linked list
- [x] Can properly insert multiple nodes into the linked list
- [x] Will return true when finding a value within the linked list that exists
- [x] Will return false when searching for a value in the linked list that does not exist
- [x] Can properly return a collection of all the values that exist in the linked list

### Day 2

- [x] Can successfully add a node to the end of the linked list
- [x] Can successfully add multiple nodes to the end of a linked list
- [x] Can successfully insert a node before a node located i the middle of a linked list
- [x] Can successfully insert a node before the first node of a linked list
- [x] Can successfully insert after a node in the middle of the linked list
- [x] Can successfully insert a node after the last node of the linked list
