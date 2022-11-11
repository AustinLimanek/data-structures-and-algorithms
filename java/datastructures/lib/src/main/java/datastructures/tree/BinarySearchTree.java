package datastructures.tree;

public class BinarySearchTree extends BinaryTree{

  public BinarySearchTree(Integer value) {
    super(value);
  }

  public BinarySearchTree() {
  }

  public void add(Integer value){
    Node newNode = new Node(value);
    if (this.getRoot() == null){
      this.setRoot(newNode);
      return;
    }
    Node current = this.getRoot();
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
    Node current = this.getRoot();
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
