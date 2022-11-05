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

  public T pop (){
    if (this.top == null) throw new NullPointerException("The stack is empty");
    Node<T> temp = this.top;
    top = top.next;
    temp.next = null;
    return temp.value;
  }

  public T peek(){
    if(top == null) throw new NullPointerException("The stack is empty");
    return top.value;
  }

  public boolean isEmpty(){
    return top == null;
  }
}
