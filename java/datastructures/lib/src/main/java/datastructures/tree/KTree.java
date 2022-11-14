package datastructures.tree;

public class KTree {

  private Knode root;
  private int i = 0;

  public KTree(int k, Integer value) {
    this.root = new Knode(k, value);
  }

  public Knode getRoot() {
    return root;
  }

  public void add(Integer value){
    root.getKnodeArray()[i] = new Knode(root.getK(), value);
    i++;
  }
}
