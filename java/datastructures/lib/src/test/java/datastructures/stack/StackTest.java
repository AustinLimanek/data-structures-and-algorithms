package datastructures.stack;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

  //push onto a stack
  @Test void stackExists(){
    Stack<String> sut = new Stack<>();
    assertNull(sut.top);
  }

  //push multiple values onto a stack
  @Test void addNodeToStack(){
    Stack<String> sut = new Stack<>();
    sut.push("comet");
    sut.push("is");
    sut.push("what");
    assertEquals("what", sut.top.value);
    assertEquals("is", sut.top.next.value);
    assertEquals("comet", sut.top.next.next.value);
  }

  //remove a node from a stack with several nodes
  @Test void popAStackNode(){
    Stack<String> sut = new Stack<>();
    sut.push("comet");
    sut.push("is");
    sut.push("what");
    assertEquals("what", sut.pop().value);
    assertEquals("is", sut.top.value);
    assertEquals("comet", sut.top.next.value);
  }

  //remove all the nodes from a stack
  @Test void popAFullStack(){
    Stack<String> sut = new Stack<>();
    sut.push("comet");
    sut.push("is");
    sut.push("cute");
    sut.pop();
    sut.pop();
    assertEquals("comet", sut.pop().value);
    assertNull(sut.top);
  }

  //attempt to remove a node from an empty stack
  @Test void popEmptyStack(){
    Stack<String> sut = new Stack<>();
    assertThrows(NullPointerException.class, sut::pop);
  }

  //attempt to peek the value of the top node of an empty stack
  @Test void peekEmptyStack(){
    Stack<String> sut = new Stack<>();
    assertThrows(NullPointerException.class, sut::peek);
  }

  //attempt to remove a node from an empty stack
  @Test void peekStack(){
    Stack<String> sut = new Stack<>();
    sut.push("Comet");
    assertEquals("Comet", sut.peek());
  }

  //read the value of the top node from a stack of many
  @Test void peekManyStack(){
    Stack<String> sut = new Stack<>();
    sut.push("hello");
    sut.push("apple");
    sut.push("California");
    sut.push("Comet");
    assertEquals("Comet", sut.peek());
  }

  //check if the single node stack is empty
  @Test void notEmptyStack(){
    Stack<String> sut = new Stack<>();
    sut.push("Comet");
    assertFalse(sut.isEmpty());
  }

  //check if an empty stack is empty
  @Test void isEmptyStack(){
    Stack<String> sut = new Stack<>();
    assertTrue(sut.isEmpty());
  }

}
