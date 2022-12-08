package datastructures.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructures.hashmap.HashMapPair;

// NOTE: Does NOT preserve insertion order!
// WARNING: Don't make K an Object or Character!
public class HashMap<K, V>
{
  ArrayList<LinkedList<HashMapPair<K, V>>> bucketArrayList;  // using ArrayList instead of array, so we can instantiate with a parameterized type
  int size;

  public HashMap(int size)
  {
    if (size < 1)
    {
      throw new IllegalArgumentException("HashMap size must be 1 or greater!");
    }

    this.size = size;
    this.bucketArrayList = new ArrayList<>(size);

    // Next part is not required, and is a little inefficient, but it makes writing HashMap operations easier
    for (int i = 0; i < this.size; i++)
    {
      bucketArrayList.add(i, new LinkedList<>());
    }
  }

  // Make sure to replace if the key is a dupe!
  public void set(K key, V value)
  {
    int hashKey = hash(key);
    LinkedList<HashMapPair<K,V>> ll = this.bucketArrayList.get(hashKey);
    for (HashMapPair<K,V> node : ll){
      if(node.getKey().equals(key)){node.setValue(value); return;}
    }
    ll.add(new HashMapPair<>(key, value));
  }

  public V get(K key)
  {
    int hashKey = hash(key);
    LinkedList<HashMapPair<K,V>> ll = this.bucketArrayList.get(hashKey);
    for (HashMapPair<K,V> node : ll){
      if(node.getKey().equals(key)) return node.getValue();
    }
    return null;
  }

  public boolean contains(K key)
  {
    int hashKey = hash(key);
    LinkedList<HashMapPair<K,V>> ll = this.bucketArrayList.get(hashKey);
    for (HashMapPair<K,V> node : ll){
      if(node.getKey().equals(key)) return true;
    }
    return false;
  }

  public List<K> keys()
  {
    List<K> list = new ArrayList<K>();
    for (LinkedList<HashMapPair<K,V>> ll: this.bucketArrayList){
      if(ll.size() > 0){
        for (HashMapPair<K,V> node : ll){
          list.add(node.getKey());
        }
      }
    }
    return list;
  }

  // Sometimes hashCode in Java can be negative! So we need to do absolute value
  // If you really want to hash things yourself, look at https://stackoverflow.com/a/113600/16889809
  // Don't use Character! Don't use Object! Don't use any object you have not overridden equals() and hashCode() on!
  // If you do this, things that should collide, won't, because Object.hashCode() is not good
  // Protip: Testing collisions is easy with Integer, because Integer hashes to its own value
  public int hash(K key)
  {
    return Math.abs(key.hashCode()) % size;
  }

  @Override
  public String toString(){
    StringBuilder sB = new StringBuilder();
    for (LinkedList<HashMapPair<K,V>> ll: this.bucketArrayList){
      sB.append(ll.toString());
      sB.append("\n");
    }
    return sB.toString();
  }

  public ArrayList<LinkedList<HashMapPair<K, V>>> getBucketArrayList() {
    return bucketArrayList;
  }

  public void setBucketArrayList(ArrayList<LinkedList<HashMapPair<K, V>>> bucketArrayList) {
    this.bucketArrayList = bucketArrayList;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
