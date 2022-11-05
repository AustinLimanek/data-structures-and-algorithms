package datastructures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

  //check that queue can be initialized with front and back set to null
  @Test void queueExists(){
    Queue<String> sut = new Queue<>();
    assertNull(sut.front);
    assertNull(sut.back);
  }

  //check that enqueue works and that the values in both the front and back are equal with a single node in the queue
  @Test void enqueueEmptyQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    assertEquals(1, sut.front.value);
    assertSame(sut.front.value, sut.back.value);
  }

  //check that enqueue works when adding two items
  @Test void enqueueQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    assertEquals(1, sut.front.value);
    assertEquals(2, sut.back.value);
  }

  //check that enqueue works when many items are added
  @Test void enqueueManyToQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);
    sut.enqueue(4);
    sut.enqueue(5);
    assertEquals(1, sut.front.value);
    assertEquals(5, sut.back.value);
  }

  //check emptiness of queue with nodes
  @Test void isEmptyOnQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    assertFalse(sut.isEmpty());
  }

  //check emptiness of empty queue
  @Test void isEmptyOnEmptyQueue(){
    Queue<Integer> sut = new Queue<>();
    assertTrue(sut.isEmpty());
  }

  //checks dequeue for single node queue and that dequeue returns the correct value
  @Test void dequeueSingleQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    assertEquals(1, sut.dequeue());
    assertTrue(sut.isEmpty());
  }

  //dequeue several times
  @Test void severalDequeue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);
    sut.dequeue();
    sut.dequeue();
    sut.dequeue();
    assertTrue(sut.isEmpty());
  }

  //throws an exception when using dequeue on empty queue
  @Test void dequeueEmptyQueue(){
    Queue<Integer> sut = new Queue<>();
    assertThrows(NullPointerException.class, sut::dequeue);
  }

  //throws an exception when using peek on empty queue
  @Test void peekEmptyQueue(){
    Queue<Integer> sut = new Queue<>();
    assertThrows(NullPointerException.class, sut::peek);
  }

  //peek on queue with many nodes
  @Test void peekManyQueue(){
    Queue<Integer> sut = new Queue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);
    assertEquals(1, sut.peek());
  }

}
