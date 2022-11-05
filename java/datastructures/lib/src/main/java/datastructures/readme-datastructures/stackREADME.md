# Stack

[Implementation Code](../linkedlist)

[Testing Code](../../../../test/java/datastructures/linkedlist/LinkedListTest.java)

## Challenge

Create a `stack` class that behaves in the LIFO (Last In First Out) principle. The `stack` and its `nodes` have a generalized typing. When instantiated the `stack` should be empty.

## Features

- [x] push: method on a stack that takes in a new value and adds a new node to the top of the stack. [Space O(1); Time O(1)]
- [x] pop: method on a stack that removes the top node on a stack and returns the value of the removed node. A `NullPointerExcepetion` is thrown when the stack is empty. [Space O(1); Time O(1)]
- [x] peek: method on a stack that returns the value of the top node. Throws `NullPointerExcepetion` if the stack is empty. [Space O(1); Time O(1)]
- [x] isEmpty: checks if the top node is null. If so, the return is true; if not, the return is false. [Space O(1); Time O(1)]

## Specifications & Tests

### Day 1 - Initialized the class

-[x] Can successfully push onto a stack
-[x] Can successfully push multiple values onto a stack
-[x] Can successfully pop off the stack
-[x] Can successfully empty a stack after multiple pops
-[x] Can successfully peek the next item on the stack
-[x] Can successfully instantiate an empty stack
-[x] Calling pop or peek on empty stack raises exception
