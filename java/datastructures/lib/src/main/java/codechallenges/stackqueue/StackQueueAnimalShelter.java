package codechallenges.stackqueue;

import datastructures.linkedlist.Node;
import datastructures.stack.Stack;

import java.util.Objects;

public class StackQueueAnimalShelter <String>{

  final private Stack<String> left = new Stack<>();
  final private Stack<String> right = new Stack<>();

  public void enqueue(String value){
    if(value != "dog" && value != "cat") throw new IllegalArgumentException("Only cats and dogs at this shelter, thank you!");
    Node<String> tempNode;
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

  public Node<String> dequeue(String value){
    if(value != "dog" && value != "cat") throw new IllegalArgumentException("We only have dogs and cats at this shelter. Thank you for your interest!");
    if(left.isEmpty()) return null;
    Node<String> tempNode;
    Node<String> adopt = null;
    while(!left.isEmpty()){
      if(left.peek() == value){
        adopt = left.pop();
        break;
      }
      tempNode = left.pop();
      right.push(tempNode.value);
    }
    while(!right.isEmpty()){
      tempNode = right.pop();
      left.push(tempNode.value);
    }
    return adopt;
  }


  public Stack<String> getLeft() {
    return left;
  }
}
