package datastructures.stack;

import datastructures.linkedlist.Node;

public class Stack<T> {

  public Node<T> top;

  public void push (T value){
    Node<T> newNode = new Node<>(value);
    if (this.top != null) {
      newNode.next = this.top;
    }
    this.top = newNode;
  }
}
