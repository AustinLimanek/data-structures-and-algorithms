package datastructures.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraceTest {

  @Test void traceTest(){
    Trace trace = new Trace();
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(8,4,23,42,16,15));
    assertEquals(new ArrayList<>(Arrays.asList(4,8,15,16,23,42)), trace.traceArray(array));
  }

  @Test void traceNegativeTest(){
    Trace trace = new Trace();
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(8,4,23,-42,16,-15));
    assertEquals(new ArrayList<>(Arrays.asList(-42,-15,4,8,16,23 )), trace.traceArray(array));
  }

  @Test void mergeSortTest(){
    Trace trace = new Trace();
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(8,4,23,-42,16,-15));
    trace.mergeSortArray(array);
    assertEquals(new ArrayList<>(Arrays.asList(-42,-15,4,8,16,23 )), array);
  }
}
