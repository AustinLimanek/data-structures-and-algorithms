package codechallenges.stackqueue;

import datastructures.linkedlist.Node;
import datastructures.stack.Stack;

public class PseudoQueue<T> {

public Stack<T> left = new Stack<>();
private Stack<T> right = new Stack<>();

public Node<T> dequeue(){
  if(left.isEmpty()) return null;
  Node<T> tempNode;
  tempNode = left.pop();
  return tempNode;
}

public void enqueue(T value){
  if(left.isEmpty()) left.push(value);
  else {
    Node<T> tempNode;
    while (!left.isEmpty()) {
      tempNode = left.pop();
      right.push(tempNode.value);
    }
    left.push(value);
    while (!right.isEmpty()) {
      tempNode = right.pop();
      left.push(tempNode.value);
    }
  }
}

  public Stack<T> getLeft() {
    return left;
  }

  public void setLeft(Stack<T> left) {
    this.left = left;
  }

  public Stack<T> getRight() {
    return right;
  }

  public void setRight(Stack<T> right) {
    this.right = right;
  }
}
