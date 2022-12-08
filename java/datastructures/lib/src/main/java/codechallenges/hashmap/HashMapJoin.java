package codechallenges.hashmap;

import datastructures.hashmap.HashMap;

import java.util.ArrayList;
import java.util.List;

public class HashMapJoin {

  public ArrayList<ArrayList<String>> hashMapJoinLeft(HashMap<String, String> left, HashMap<String, String> right) {
    List<String> leftKeys = left.keys();

    ArrayList<ArrayList<String>> answer = new ArrayList<>();

    for (String key : leftKeys) {
      ArrayList<String> row = new ArrayList<>();
      row.add(key);
      row.add(left.get(key));
      row.add(right.get(key));
      answer.add(row);
    }

    return answer;
  }
}
