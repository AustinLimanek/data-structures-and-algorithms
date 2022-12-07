package codechallenges.treeinteraction;

import codechallenges.TreeIntersection.TreeIntersection;
import datastructures.tree.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeInteractionTests {

  BinarySearchTree<Integer> oak = new BinarySearchTree<>();
  BinarySearchTree<Integer> maple = new BinarySearchTree<>();

  public void init(){
    oak.add(34);
    oak.add(56);
    oak.add(25);
    oak.add(13);
    oak.add(22);
    oak.add(48);
    oak.add(5);
    oak.add(100);
    oak.add(2);
    maple.add(31);
    maple.add(34);
    maple.add(13);
    maple.add(1);
    maple.add(15);
    maple.add(72);
    maple.add(98);
    maple.add(2);
    maple.add(56);
  }

  @Test
  public void checkBasic(){
    init();
    TreeIntersection treeIntersection = new TreeIntersection();
    assertEquals(new HashSet<>(Arrays.asList(34, 2, 56, 13)), treeIntersection.intersectingTrees(oak, maple));
  }

  @Test
  public void checkBasicNot(){
    TreeIntersection treeIntersection = new TreeIntersection();
    assertNull(treeIntersection.intersectingTrees(oak, maple));
  }

  @Test
  public void checkBasicSingle(){
    oak.add(3);
    TreeIntersection treeIntersection = new TreeIntersection();
    assertNull(treeIntersection.intersectingTrees(oak, maple));
  }
}
