package datastructures.queue;

import datastructures.linkedlist.Node;

public class Queue<T> {

  public Node<T> front;
  public Node<T> back;

  public boolean isEmpty (){
    return back == null;
  }

  public void enqueue (T value) {
    Node<T> newNode = new Node<>(value);
    if (isEmpty()) {
        front = newNode;
        back = newNode;
    }
    else if (front == back){
      back = newNode;
      front.next = back;
    }
    else{
      back.next = newNode;
      back = newNode;
    }
  }

  public T dequeue (){
    if(isEmpty()) throw new NullPointerException("This queue is empty");
    if(front == back){
      T value = front.value;
      front = null;
      back = null;
      return value;
    }
    else{
      Node<T> temp = front;
      front = front.next;
      temp.next = null;
      return temp.value;
    }
  }

  public T peek (){
    if(isEmpty()) throw new NullPointerException("This queue is empty");
    return front.value;
  }

}
