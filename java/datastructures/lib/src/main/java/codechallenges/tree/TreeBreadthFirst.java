package codechallenges.tree;

import datastructures.queue.Queue;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.Node;

import java.util.ArrayList;

public class TreeBreadthFirst <T>{

  public ArrayList<T> breadthFirst(BinarySearchTree<T> tree){
    ArrayList<T> output = new ArrayList<>();
    if (tree.getRoot() == null) return null;
    Queue<Node<T>> queue = new Queue<>();
    queue.enqueue(tree.getRoot());
    while(!queue.isEmpty()){
      if(queue.front.value.getLeft() != null){
        queue.enqueue(queue.front.value.getLeft());
      }
      if(queue.front.value.getRight() != null){
        queue.enqueue(queue.front.value.getRight());
      }

      output.add(queue.front.value.getValue());
      queue.dequeue();
    }
    return output;
  }
}
