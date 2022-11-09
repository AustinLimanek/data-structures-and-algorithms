package codechallenges.stackqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackQueueAnimalShelterTest {

  @Test
  public void exceptionEnqueue(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    assertThrows(IllegalArgumentException.class, ()->sut.enqueue("comet"));
  }

  @Test
  public void exceptionDequeue(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    assertThrows(IllegalArgumentException.class, ()->sut.dequeue("comet"));
  }

  @Test
  public void enqueueCatsAndDogs(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    sut.enqueue("cat");
    sut.enqueue("cat");
    sut.enqueue("dog");
    sut.enqueue("cat");
    assertEquals("dog", sut.getLeft().top.next.next.value);
  }

  @Test
  public void dequeueDogFromCatsAndDogs(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    sut.enqueue("cat");
    sut.enqueue("cat");
    sut.enqueue("dog");
    sut.enqueue("cat");
    assertEquals("dog", sut.dequeue("dog").value);
  }

  @Test
  public void dequeueCatFromCatsAndDogs(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    sut.enqueue("cat");
    sut.enqueue("cat");
    sut.enqueue("dog");
    sut.enqueue("cat");
    assertEquals("cat", sut.dequeue("cat").value);
    assertEquals("dog", sut.getLeft().top.next.value);
  }

  @Test
  public void dequeueEmpty(){
    StackQueueAnimalShelter<String> sut = new StackQueueAnimalShelter<>();
    assertNull(sut.dequeue("dog"));
  }

}
