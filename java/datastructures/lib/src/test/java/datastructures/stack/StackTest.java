package datastructures.stack;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

  @Test void stackExists(){
    Stack<String> sut = new Stack<>();
    assertNull(sut.top);
  }
}
