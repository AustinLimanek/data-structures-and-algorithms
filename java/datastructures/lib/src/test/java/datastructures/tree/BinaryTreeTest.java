package datastructures.tree;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

  @Test
  public void initializeEmptyBinaryTree(){
    BinaryTree<Integer> bt = new BinaryTree<>();
    assertNull(bt.getRoot());
  }

  @Test
  public void initializeSingleNodeBinaryTree(){
    BinaryTree<Integer> bt = new BinaryTree<>(5);
    assertEquals(5, bt.getRoot().getValue());
  }

  @Test
  public void initializeEmptyBinarySearchTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    assertNull(bst.getRoot());
  }

  @Test
  public void initializeSingleNodeBinarySearchTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(5);
    assertEquals(5, bst.getRoot().getValue());
  }

  @Test
  public void addToEmptyBinarySearchTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.add(5);
    assertEquals(5, bst.getRoot().getValue());
  }

  @Test
  public void addToSingleNodeBinarySearchTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    bst.add(5);
    assertEquals(6, bst.getRoot().getValue());
    assertEquals(5, bst.getRoot().getLeft().getValue());
  }

  @Test
  public void addSeveralBinarySearchTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
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
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
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

  @Test
  public void preOrderBinaryTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6,5,3,10,8));
    assertEquals(expected, bst.preOrder(array, bst.getRoot()));
  }

  @Test
  public void inOrderBinaryTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3,5,6,8,10));
    assertEquals(expected, bst.inOrder(array, bst.getRoot()));
  }

  @Test
  public void postOrderBinaryTree(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3,5,8,10,6));
    assertEquals(expected, bst.postOrder(array, bst.getRoot()));
  }

  @Test
  public void arrays(){
    KTree oak = new KTree(3, 7);
    oak.add(6);
    System.out.println(oak.getRoot().getKnodeArray()[1]);
  }

  //testing for the treeMax method: the next three tests
  @Test void maxOfOne(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(6);
    assertEquals(6, bst.treeMax());
  }

  @Test void maxOfMany(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    assertEquals(10, bst.treeMax());
  }

  @Test void maxNull(){
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    assertNull(bst.treeMax());
  }

}
