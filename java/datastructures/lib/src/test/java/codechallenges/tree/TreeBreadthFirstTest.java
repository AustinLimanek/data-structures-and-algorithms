package codechallenges.tree;

import datastructures.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeBreadthFirstTest {

  @Test
  void breadthOnMany(){
    TreeBreadthFirst<Integer> meth = new TreeBreadthFirst<>();
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    bst.add(5);
    bst.add(10);
    bst.add(8);
    bst.add(3);
    assertEquals(10, bst.treeMax());
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6,5,10,3,8));
    assertEquals(expected, meth.breadthFirst(bst));
  }

  @Test
  void breadthOnOne(){
    TreeBreadthFirst<Integer> meth = new TreeBreadthFirst<>();
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(6);
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(6);
    assertEquals(expected, meth.breadthFirst(bst));
  }
}
