package datastructures.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  //Checks basic insertion and getting functionality
  @Test void simpleSetAndGetHashMap(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    assertEquals(3, hashMap.get("this"));
  }

  @Test void reSetAndGetHashMap(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    hashMap.set("this", 4);
    assertEquals(4, hashMap.get("this"));
  }

  @Test void reSetWithLargeHashMap(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    hashMap.set("Austin", 29);
    hashMap.set("Ben", 29);
    hashMap.set("Sasha", 30);
    hashMap.set("Comet", 5);
    hashMap.set("this", 4);
    assertEquals(4, hashMap.get("this"));
  }

  @Test void sizeOutOfRange(){
    assertThrows( IllegalArgumentException.class, ()-> new HashMap<>(-1));
  }

  @Test void nullGetHashMap(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    assertNull(hashMap.get("what"));
  }

  @Test void allKeysOfHashMap(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    hashMap.set("Austin", 29);
    hashMap.set("Ben", 29);
    hashMap.set("Sasha", 30);
    hashMap.set("Comet", 5);
    hashMap.set("Washington", 7);
    ArrayList<String> expected = new ArrayList<>(Arrays.asList("this", "Sasha", "Ben", "Austin", "Comet", "Washington"));
    assertEquals(expected, hashMap.keys());
  }

  @Test void collisionCheckGet(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    hashMap.set("this", 3);
    hashMap.set("Austin", 29);
    hashMap.set("Ben", 29);
    hashMap.set("Sasha", 30);
    hashMap.set("Comet", 5);
    hashMap.set("Washington", 2022-1886);
    hashMap.set("United States", 2023-1776);
    System.out.println(hashMap);
    assertEquals(136, hashMap.get("Washington"));
  }

  @Test void hashInRange(){
    HashMap<String, Integer> hashMap = new HashMap<>(5);
    StringBuilder sB = new StringBuilder();
    for(int i = 0; i < Math.random()*100; i++){
      sB.append(i);
      assertTrue(hashMap.hash(sB.toString()) < 5);
    }
  }

}
