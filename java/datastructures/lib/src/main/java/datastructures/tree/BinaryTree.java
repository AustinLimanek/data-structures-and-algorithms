package datastructures.tree;
import datastructures.queue.Queue;

import java.util.ArrayList;

public class BinaryTree<T> {

  private Node<T> root;

  public BinaryTree(Integer value) {
    this.root = new Node<T>(value);
  }

  public BinaryTree() {
    this.root = null;
  }

  public ArrayList<Integer> preOrder(ArrayList<Integer> array, Node<T> node){
    if(node == null) return array;

    array.add(node.getValue());
    preOrder(array, node.getLeft());
    preOrder(array, node.getRight());

    return array;
  }

  public ArrayList<Integer> inOrder(ArrayList<Integer> array, Node<T> node){
    if(node == null) return array;

    inOrder(array, node.getLeft());
    array.add(node.getValue());
    inOrder(array, node.getRight());

    return array;
  }

  public ArrayList<Integer> postOrder(ArrayList<Integer> array, Node<T> node){
    if(node == null) return array;

    postOrder(array, node.getLeft());
    postOrder(array, node.getRight());
    array.add(node.getValue());

    return array;
  }

  public Integer treeMax(){
    if (this.root == null) return null;
    Integer max = this.root.getValue();
    Queue<Node<T>> queue = new Queue<>();
    queue.enqueue(this.root);
    while(!queue.isEmpty()){
      if(queue.front.value.getLeft() != null){
        queue.enqueue(queue.front.value.getLeft());
      }
      if(queue.front.value.getRight() != null){
        queue.enqueue(queue.front.value.getRight());
      }
      if(queue.front.value.getValue() > max){
        max = queue.front.value.getValue();
      }
      queue.dequeue();
    }
    return max;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }
}
