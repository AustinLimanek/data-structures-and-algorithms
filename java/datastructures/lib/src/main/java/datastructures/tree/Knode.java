package datastructures.tree;

public class Knode <T>{

  private final int k;
  private T value;
  private final Knode<T>[] knodeArray;

  public Knode(int k, T value) {
    this.k = k;
    this.value = value;
    this.knodeArray = new Knode[k];
  }

  public int getK() {
    return k;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Knode<T>[] getKnodeArray() {
    return knodeArray;
  }
}
