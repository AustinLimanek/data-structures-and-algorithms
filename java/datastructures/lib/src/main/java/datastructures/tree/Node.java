package datastructures.tree;

public class Node<T> {

  private Integer value;
  private Node<T> left;
  private Node<T> right;

  public Node(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }
}
