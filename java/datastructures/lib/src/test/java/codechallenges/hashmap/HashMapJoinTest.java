package codechallenges.hashmap;

import datastructures.hashmap.HashMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapJoinTest {

  HashMap<String, String> left = new HashMap<>(20);
  HashMap<String, String> right = new HashMap<>(20);

  public void init(){
    left.set("diligent", "employed");
    left.set("fond", "enamored");
    left.set("guide", "usher");
    left.set("outfit", "garb");
    left.set("wrath", "anger");
    right.set("diligent", "idle");
    right.set("fond", "averse");
    right.set("guide", "follow");
    right.set("flow", "jam");
    right.set("wrath", "delight");
  }


  @Test
  public void joinLeftBasicCheck(){
    init();
    HashMapJoin crm = new HashMapJoin();
    ArrayList<ArrayList<String>> answer = crm.hashMapJoinLeft(left,right);
    ArrayList<String> row = new ArrayList<>();
    row.add("diligent");
    row.add("employed");
    row.add("idle");
    assertTrue(answer.contains(row));
  }

  @Test
  public void joinLeftNullCheck(){
    init();
    HashMapJoin crm = new HashMapJoin();
    ArrayList<ArrayList<String>> answer = crm.hashMapJoinLeft(left,right);
    ArrayList<String> row = new ArrayList<>();
    row.add("outfit");
    row.add("garb");
    row.add(null);
    assertTrue(answer.contains(row));
  }

  @Test
  public void joinLeftLengthCheck(){
    init();
    HashMapJoin crm = new HashMapJoin();
    ArrayList<ArrayList<String>> answer = crm.hashMapJoinLeft(left,right);
    assertEquals(left.keys().size(), answer.size());
  }


}
