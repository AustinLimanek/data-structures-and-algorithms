package datastructures.tree;

import java.util.ArrayList;

public class BinaryTree {

  private Node root;

  public BinaryTree(Integer value) {
    this.root = new Node(value);
  }

  public BinaryTree() {
    this.root = null;
  }

  public ArrayList<Integer> preOrder(ArrayList<Integer> array, Node node){
    if(node == null) return array;

    array.add(node.getValue());
    preOrder(array, node.getLeft());
    preOrder(array, node.getRight());

    return array;
  }

  public ArrayList<Integer> inOrder(ArrayList<Integer> array, Node node){
    if(node == null) return array;

    inOrder(array, node.getLeft());
    array.add(node.getValue());
    inOrder(array, node.getRight());

    return array;
  }

  public ArrayList<Integer> postOrder(ArrayList<Integer> array, Node node){
    if(node == null) return array;

    postOrder(array, node.getLeft());
    postOrder(array, node.getRight());
    array.add(node.getValue());

    return array;
  }

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }
}
