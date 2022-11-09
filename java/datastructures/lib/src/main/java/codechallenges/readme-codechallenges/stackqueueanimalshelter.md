# Challenge Summary: Stack Queue Animal Shelter

Write a class that follows the FIFO (first in first out) principle that imitates the operations of an animal shelter. The shelter only has dogs and cats for animals. A visitor can offer a preference for an animal that they want to adopt. The animal that matches the preference that has been in the shelter the longest is the one that the visitor will take home with them. New animals should be added to the end of the queue to allow for the other animals a change to get adopted first.

## Whiteboard Process

![whiteboard](images/stackqueueanimalshelter.png)

## Approach & Efficiency

Two stacks are used. The pseudo queue has two properties of `left` and `right`, which have the type of `Stack`. Stack is a class that has the methods of pop, push, peek, and isEmpty that are typical of a stack data structure. The resting state of queue has its node sitting in the left stack.

Dequeue: Takes in an animal preference that can be either a dog or a cat. Elements are popped from the left stack. If a different preference is reported then an `IllegalArgumentException` is thrown.

O(n) for both space and time complexity. The animals in the left stack will need to be searched through by moving them to the right stack, thus creating up to n, the size of the left stack, to the right stack. The number of operation is proportional to the number of nodes in the left stack, n.

Enqueue: nodes are popped and the pushed to the right stack. Once the left stack is empty the new node is push to the left stack. The right stack is then fully popped and those nodes are pushed to the left stack. The left stack now has an additional node at the base of the stack. This system ensure that the FIFO principle is being followed.

This has a space complexity of O(n) because the number of new nodes created is proportional to the number of nodes that already exist in the left stack. The time complexity if O(n) because the transfer between the two stacks is again proportional to the number of nodes in the left stack.


## Solution

[code](../stackqueue/StackQueueAnimalShelter.java)

[tests](../../../../test/java/codechallenges/stackqueue/StackQueueAnimalShelterTest.java)
