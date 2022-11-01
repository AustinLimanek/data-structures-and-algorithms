package datastructures.linkedlist;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
  //instantiate an empty linked list
  @Test void linkedListExists()
    {
      LinkedList<String> sut = new LinkedList<>();
      assertNull(sut.head);
    }

  //can properly insert into a linked list
  // head property will properly point to the first node in the linked list
  //can properly insert multiple nodes into the linked list
  @Test void insertIntoList()
  {
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    assertEquals("hello", sut.head.value);
    assertEquals("world", sut.head.next.value);
  }

  //Will return true when finding a value within the linked list that exists
  //Will return false when not finding a value within the linked list
  @Test void testIncludes()
  {
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    assertTrue(sut.includes("world"));
    assertFalse(sut.includes("austin"));
  }

  //Can properly return a collection of all the values that exist in the linked list
  @Test void testToString()
  {
    LinkedList<Integer> sut = new LinkedList<>();
    sut.insert(2);
    sut.insert(1);
    assertEquals("{ 1 } -> { 2 } -> Null", sut.toString());
  }

  //Can add a node in the linked list at the end of the linked list
  @Test void insertAtEndOfList()
  {
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    sut.endAppend(" and beyond");
    assertEquals(" and beyond", sut.head.next.next.value);
  }

  //Can add a new value before a given value in a linked list.
  @Test void insertBeforeExistingValue(){
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    sut.insertBefore("world", ", ");
    assertEquals(", ", sut.head.next.value);
    sut.insertBefore("hello", "Oh, ");
    assertEquals("Oh, ", sut.head.value);
    sut.insertBefore("world", "1");
    sut.insertBefore("world", "2");
    System.out.println(sut);
  }

  // Checks the case of a linked list not having the relative value to insert the new value before.
  @Test void checkException(){
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    assertThrows(IllegalArgumentException.class, () -> sut.insertBefore("hell", "no"));
  }

  //check if adding after works
  @Test void insertAfterExistingValue(){
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    sut.insertAfter("hello", "!");
    assertEquals("world", sut.head.next.next.value);
  }

  //check is adding after works at the end of a linked list
  @Test void insertAfterExistingEndValue(){
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    sut.insertAfter("world", "!");
    assertEquals("!", sut.head.next.next.value);
  }

  // Checks the case of a linked list not having the relative value to insert the new value before.
  @Test void checkExceptionInsertAfter(){
    LinkedList<String> sut = new LinkedList<>();
    sut.insert("world");
    sut.insert("hello");
    assertThrows(IllegalArgumentException.class, () -> sut.insertAfter("hell", "no"));
  }


}
