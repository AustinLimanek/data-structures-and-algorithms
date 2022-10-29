package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
  //instantiate an empty linked list
  @Test void linkedListExists()
    {
      LinkedList sut = new LinkedList();
      assertNull(sut.head);
    }

  //can properly insert into a linked list
  // head property will properly point to the first node in the linked list
  //can properly insert multiple nodes into the linked list
  @Test void insertIntoList()
  {
    LinkedList sut = new LinkedList();
    sut.insert("world");
    sut.insert("hello");
    assertEquals("hello", sut.head.value);
    assertEquals("world", sut.head.next.value);
  }

  //Will return true when finding a value within the linked list that exists
  //Will return false when not finding a value within the linked list
  @Test void testIncludes()
  {
    LinkedList sut = new LinkedList();
    sut.insert("world");
    sut.insert("hello");
    assertTrue(sut.includes("world"));
    assertFalse(sut.includes("austin"));
  }

  //Can properly return a collection of all the values that exist in the linked list
  @Test void testToAString()
  {
    LinkedList sut = new LinkedList();
    sut.insert("world");
    sut.insert("hello");
    assertEquals("{ hello } -> { world } -> Null", sut.toAString());
  }



}
