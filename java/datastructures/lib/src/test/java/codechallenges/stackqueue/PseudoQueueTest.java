package codechallenges.stackqueue;

import org.junit.jupiter.api.Test;

import static codechallenges.stackqueue.StackQueueBrackets.bracketValidation;
import static org.junit.jupiter.api.Assertions.*;

public class PseudoQueueTest {

  @Test void dequeueEmpty(){
    PseudoQueue<String> test = new PseudoQueue<>();
    assertNull(test.dequeue());
  }

  @Test void enqueueToEmpty(){
    PseudoQueue<String> test = new PseudoQueue<>();
    test.enqueue("hello");
    assertEquals("hello", test.left.top.value);
  }

  @Test void dequeueSinglePseudoQueue(){
    PseudoQueue<String> test = new PseudoQueue<>();
    test.enqueue("hello");
    test.dequeue();
    assertTrue(test.left.isEmpty());
  }

  @Test void enqueueManyPseudoQueue(){
    PseudoQueue<String> test = new PseudoQueue<>();
    test.enqueue("hello");
    test.enqueue("to");
    test.enqueue("you");
    test.enqueue("world");
    assertEquals("world", test.left.top.next.next.next.value);
  }

  @Test void dequeueFromManyPseudoQueue(){
    PseudoQueue<String> test = new PseudoQueue<>();
    test.enqueue("hello");
    test.enqueue("to");
    test.enqueue("you");
    test.dequeue();
    assertEquals("to", test.left.peek());
  }

  @Test void brackets(){
    assertTrue(bracketValidation("()[[Extra Characters]]"));
    assertTrue(bracketValidation("(){}[[]]"));
    assertTrue(bracketValidation("{}{Code}[Fellows](())"));
    assertFalse(bracketValidation("[({}]"));
    assertFalse(bracketValidation("(]("));
    assertFalse(bracketValidation("{(])"));
    assertFalse(bracketValidation("{"));
    assertFalse(bracketValidation(")"));
    assertFalse(bracketValidation("[}"));
  }

}
