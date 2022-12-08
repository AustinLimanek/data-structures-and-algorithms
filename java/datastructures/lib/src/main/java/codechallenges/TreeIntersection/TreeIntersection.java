package codechallenges.TreeIntersection;

import datastructures.hashmap.HashMap;
import datastructures.queue.Queue;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.BinaryTree;
import datastructures.tree.Node;

import java.util.HashSet;

public class TreeIntersection {

  public HashSet<Integer> intersectingTrees(BinarySearchTree<Integer> oak, BinarySearchTree<Integer> maple){
    if(oak.getRoot() == null) return null;
    if(maple.getRoot() == null) return null;

    HashMap<Integer, Integer> map = new HashMap<>(30);
    Queue<Node<Integer>> hold = new Queue<>();

    hold.enqueue(oak.getRoot());

    while( !hold.isEmpty()){
      if (hold.peek().getRight() != null){
        hold.enqueue(hold.peek().getRight());
      }
      if (hold.peek().getLeft() != null){
        hold.enqueue(hold.peek().getLeft());
      }
      map.set(hold.dequeue().getValue(), 0);
    }

    HashSet<Integer> answer = new HashSet<>();

    hold.enqueue(maple.getRoot());
    Integer check = null;

    while( !hold.isEmpty()){
      if (hold.peek().getRight() != null){
        hold.enqueue(hold.peek().getRight());
      }
      if (hold.peek().getLeft() != null){
        hold.enqueue(hold.peek().getLeft());
      }
      check = hold.dequeue().getValue();
      if (map.contains(check)) answer.add(check);
    }

    return answer;
  }

}
