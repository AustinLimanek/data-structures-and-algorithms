package codechallenges.linkedlist;

import datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import java.awt.geom.Line2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListChallengesTest
{
  @Test
  void testAChallenge()
  {
    LinkedListChallenges sut = new LinkedListChallenges();
    sut.linkedListChallenge06();
    System.out.println("test something here");
    assertTrue(true);
  }

  @Test
  void zippingLinkedLists()
  {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> linked1 = new LinkedList<>();
    LinkedList<Integer> linked2 = new LinkedList<>();
    linked1.insert(1);
    linked1.endAppend(2);
    linked1.endAppend(3);
    linked1.endAppend(4);
    linked1.endAppend(5);
    linked2.insert(11);
    linked2.endAppend(12);
    linked2.endAppend(13);
    LinkedList<Integer> result = sut.zipper(linked1, linked2);
    System.out.println(result.toString());
    assertEquals(8, result.size());
  }

  @Test
  void zippingLinkedListsWithTwoLarger()
  {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> linked1 = new LinkedList<>();
    LinkedList<Integer> linked2 = new LinkedList<>();
    linked1.insert(1);
    linked1.endAppend(2);
    linked1.endAppend(3);
    linked1.endAppend(4);
    linked2.insert(11);
    linked2.endAppend(12);
    linked2.endAppend(13);
    linked2.endAppend(14);
    linked2.endAppend(15);
    linked2.endAppend(16);
    LinkedList<Integer> result = sut.zipper(linked1, linked2);
    System.out.println(result.toString());
    assertEquals(10, result.size());
  }

  @Test
  void firstNull()
  {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> linked1 = new LinkedList<>();
    LinkedList<Integer> linked2 = new LinkedList<>();
    linked2.insert(11);
    linked2.endAppend(12);
    linked2.endAppend(13);
    linked2.endAppend(14);
    linked2.endAppend(15);
    linked2.endAppend(16);
    LinkedList<Integer> result = sut.zipper(linked1, linked2);
    System.out.println(result.toString());
    assertEquals(6, result.size());
  }

  @Test
  void secondNull()
  {
    LinkedListChallenges sut = new LinkedListChallenges();
    LinkedList<Integer> linked1 = new LinkedList<>();
    LinkedList<Integer> linked2 = new LinkedList<>();
    linked1.insert(1);
    linked1.endAppend(2);
    linked1.endAppend(3);
    linked1.endAppend(4);
    LinkedList<Integer> result = sut.zipper(linked1, linked2);
    System.out.println(result.toString());
    assertEquals(4, result.size());
  }

}
