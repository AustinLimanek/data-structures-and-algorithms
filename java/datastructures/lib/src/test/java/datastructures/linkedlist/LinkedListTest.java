package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
  @Test void linkedListExists()
    {
      LinkedList sut = new LinkedList();
      assertNull(sut.head);
    }

  @Test void insertIntoList()
  {
    LinkedList sut = new LinkedList();
    sut.insert("world");
    sut.insert("hello");
    assertEquals("hello", sut.head.value);
    assertEquals("world", sut.head.next.value);
  }



}
