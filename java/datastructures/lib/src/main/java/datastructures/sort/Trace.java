package datastructures.sort;

import java.util.ArrayList;

public class Trace {

  public ArrayList<Integer> traceArray(ArrayList<Integer> array){
    int length = array.size();
    int min;
    Integer temp;
    for (int i = 0; i < length - 1; i++){
      min = i;
      for (int j = i + 1; j < length; j++){
        if ( array.get(min) > array.get(j)){
          min = j;
        }
      }
      temp = array.get(min);
      array.set(min, array.get(i));
      array.set(i, temp);
    }
    return array;
  }
}
