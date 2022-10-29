# Single Linked List

[Implementation Code](../linkedlist)
[Testing Code](../../../../test/java)

## Challenge

Create a linked list data type by defining two classes. First, Node which will take a value on construction and has a parameter called next that is of datatype Node. This means that Node is a self-referential class. On instantiation a new node should point to null. Second, LinkedList which will have a parameter with data type node called head, which will be the starting location of the list. Methods should be in the LinkedList class.

## Features

- insert: adds a new node with a value in O(1) time
- includes: searches a linkedlist for a specified value -> returns boolean
- toString: converts the linkedlist into a string of the form "{ e1 } -> { e2 } -> { e3 } -> null"

## Specifications & Tests

- Can successfully instantiate an empty linked list
- Can properly insert into the linked list
- The head property will properly point to the first node in the linked list
- Can properly insert multiple nodes into the linked list
- Will return true when finding a value within the linked list that exists
- Will return false when searching for a value in the linked list that does not exist
- Can properly return a collection of all the values that exist in the linked list
