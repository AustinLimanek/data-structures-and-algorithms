# Queue

[Implementation Code](../queue/Queue.java)

[Testing Code](../../../../test/java/datastructures/queue/QueueTest.java)

## Challenge

Create a `Queue` class that follows the FIFO (First In First Out) principle. Both the `Queue` and the `Nodes` have a generalizable typing. On instantiation the queue should be empty and have a `front` and `back` property pointing to `null`.

## Features

- [x] enqueue: Takes in a value with any type and instantiates a `node` with the given value and adds it to the queue. If the `queue` is empty, the new `node` is both the `front` and the `back` of the `queue`. If there is already an existing `node` the new `node` is added behind all existing `nodes` in the `queue`. [Space O(1); Time O(1)]
- [x] dequeue: A method that acts on a `queue` and removes the `node` that the `front` `node` points at and removes this node from the `queue`. The next `node` in line is the new `front`. The return is equal to the value belonging to the removed node. If the `queue` is empty, a `NullPointerException` is thrown. [Space O(1); Time O(1)]
- [x] peek: returns the value of the `node` being pointed at by the `front` property. If the `queue` is empty a `NullPointerExcepetion` is thrown. [Space O(1); Time O(1)]
- [x] isEmpty: returns a boolean. If the `front` property of the `queue` is null, then return true; if not, then return false. [Space O(1); Time O(1)]

## Specifications & Tests

### Day 1: Initialized the class

- [x] Can successfully enqueue into a queue
- [x] Can successfully enqueue multiple values into a queue
- [x] Can successfully dequeue out of a queue the expected value
- [x] Can successfully peek into a queue, seeing the expected value
- [x] Can successfully empty a queue after multiple dequeues
- [x] Can successfully instantiate an empty queue
- [x] Calling dequeue or peek on empty queue raises exception
