package datastructures.tree;

public class BinarySearchTree<T> extends BinaryTree<T>{

  public BinarySearchTree(Integer value) {
    super(value);
  }

  public BinarySearchTree() {
  }

  public void add(Integer value){
    Node<T> newNode = new Node<T>(value);
    if (this.getRoot() == null){
      this.setRoot(newNode);
      return;
    }
    Node<T> current = this.getRoot();
    while(current != null){
      if (value < current.getValue()){
        if(current.getLeft() == null){
          current.setLeft(newNode);
        }
        else{
          current = current.getLeft();
        }
      }
      else if(value > current.getValue()){
        if(current.getRight() == null){
          current.setRight(newNode);
        }
        else{
          current = current.getRight();
        }
      }
      else{
        return;
      }
    }
  }

  public boolean contains(Integer value){
    if (this.getRoot() == null) return false;
    Node<T> current = this.getRoot();
    while(current != null){
      if (value < current.getValue()){
        if(current.getLeft() == null){
          return false;
        }
        else{
          current = current.getLeft();
        }
      }
      else if(value > current.getValue()){
        if(current.getRight() == null){
          return false;
        }
        else{
          current = current.getRight();
        }
      }
      else{
        return true;
      }
    }
    return false;
  }





}
