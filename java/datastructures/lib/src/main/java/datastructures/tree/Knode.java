package datastructures.tree;

public class Knode {

  private int k;
  private Integer value;
  private Knode[] knodeArray;

  public Knode(int k, Integer value) {
    this.k = k;
    this.value = value;
    this.knodeArray = new Knode[k];
  }

  public int getK() {
    return k;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Knode[] getKnodeArray() {
    return knodeArray;
  }
}
