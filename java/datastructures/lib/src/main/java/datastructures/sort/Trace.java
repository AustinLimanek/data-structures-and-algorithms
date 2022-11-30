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

  public void mergeSortArray(ArrayList<Integer> array){
    int size = array.size();

    if (size > 1){

      int mid = size/2;
      ArrayList<Integer> left = new ArrayList<>(array.subList(0,mid));
      ArrayList<Integer> right = new ArrayList<>(array.subList(mid,size));

      mergeSortArray(left);
      mergeSortArray(right);
      mergeArrays(left, right, array);
    }

  }

  public void mergeArrays(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> array){
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.size() && j < right.size()){

      if (left.get(i) < right.get(j)){
        array.set(k, left.get(i));
        i++;
      }
      else{
        array.set(k, right.get(j));
        j++;
      }
      k++;
    }

    if (i == left.size()){
      for (int x = j; x < right.size(); x++){
        array.set(k, right.get(x));
        k++;
      }
    }
    else{
      for (int x = i; x < left.size(); x++){
        array.set(k, left.get(x));
        k++;
      }
    }
  }
}
