package datastructures.tree;

import datastructures.queue.Queue;
import org.checkerframework.checker.units.qual.K;

import java.util.ArrayList;

public class KTree <T>{

  private final Knode<T> root;

  public KTree(int k, T value) {
    this.root = new Knode<T>(k, value);
  }

  public Knode<T> getRoot() {
    return root;
  }

  public void add(T value){
    Queue<Knode<T>> queue = new Queue<>();
    queue.enqueue(this.getRoot());
    Knode<T> current = this.getRoot();
    int arrIn;
    while(!queue.isEmpty()){
      arrIn = 0;
      for( Knode<T> knode : current.getKnodeArray()){
        if(knode != null) {
          queue.enqueue(knode);
        }
        else{
          current.getKnodeArray()[arrIn] = new Knode<>(this.getRoot().getK(), value);
          return;
        }
        arrIn++;
      }
      queue.dequeue();
      current = queue.front.value;
    }
  }

  public ArrayList<T> printBreadth(){
    Queue<Knode<T>> queue = new Queue<>();
    queue.enqueue(this.getRoot());
    Knode<T> current = this.getRoot();
    ArrayList<T> output = new ArrayList<>();
    output.add(current.getValue());
    while(!queue.isEmpty()){
      for( Knode<T> knode : current.getKnodeArray()){
        if(knode != null) {
          queue.enqueue(knode);
          output.add(knode.getValue());
        }
      }
      queue.dequeue();
      if(queue.isEmpty()) return output;
      current = queue.front.value;
    }
    return output;
  }

  static String fizzBuzz(Integer value){
    StringBuilder output = new StringBuilder();
    if((value % 3) == 0){
      output.append("Fizz");
    }
    if((value % 5) == 0){
      output.append("Buzz");
    }
    if(output.length() == 0) output.append(value);
    return output.toString();
  }


  public KTree<String> treeFizzBuzz(){
    int k = this.getRoot().getK();
    Queue<Knode<Integer>> queue = new Queue<>();
    KTree<String> output = new KTree<>(k, fizzBuzz((Integer) getRoot().getValue()));
    queue.enqueue((Knode<Integer>) this.getRoot());
    Knode<Integer> current = (Knode<Integer>) this.getRoot();

    while(!queue.isEmpty()){
      for( Knode<Integer> knode : current.getKnodeArray()){
        if(knode != null) {
          queue.enqueue(knode);
          output.add(fizzBuzz(knode.getValue()));
        }
      }
      queue.dequeue();
      if(queue.isEmpty()) return output;
      current = queue.front.value;
    }
    return output;
  }

}
