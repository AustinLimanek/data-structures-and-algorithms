package datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

  @Test
  public void initializeEmptyBinaryTree(){
    BinaryTree bt = new BinaryTree();
    assertNull(bt.getRoot());
  }

  @Test
  public void initializeSingleNodeBinaryTree(){
    BinaryTree bt = new BinaryTree(5);
    assertEquals(5, bt.getRoot().getValue());
  }

  @Test
  public void initializeEmptyBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree();
    assertNull(bst.getRoot());
  }

  @Test
  public void initializeSingleNodeBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree(5);
    assertEquals(5, bst.getRoot().getValue());
  }

  @Test
  public void addToEmptyBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(5);
    assertEquals(5, bst.getRoot().getValue());
  }

  @Test
  public void addToSingleNodeBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree(6);
    bst.add(5);
    assertEquals(6, bst.getRoot().getValue());
    assertEquals(5, bst.getRoot().getLeft().getValue());
  }

  @Test
  public void addSeveralBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    assertEquals(6, bst.getRoot().getValue());
    assertEquals(5, bst.getRoot().getLeft().getValue());
    assertEquals(10, bst.getRoot().getRight().getValue());
    assertEquals(8, bst.getRoot().getRight().getLeft().getValue());
    assertEquals(3, bst.getRoot().getLeft().getLeft().getValue());
  }

  @Test
  public void containsForBinarySearchTree(){
    BinarySearchTree bst = new BinarySearchTree(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    assertTrue(bst.contains(6));
    assertTrue(bst.contains(5));
    assertTrue(bst.contains(10));
    assertTrue(bst.contains(8));
    assertTrue(bst.contains(3));
    assertFalse(bst.contains(42));
  }

}
