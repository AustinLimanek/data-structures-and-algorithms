package datastructures.tree;

public class BinaryTree {

  private Node root;

  public BinaryTree(Integer value) {
    this.root = new Node(value);
  }

  public BinaryTree() {
    this.root = null;
  }

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }
}
