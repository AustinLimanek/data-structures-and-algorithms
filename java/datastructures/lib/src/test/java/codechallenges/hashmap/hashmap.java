package codechallenges.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class hashmap {

  @Test
  public void repeatWords() {
    HashMostFrequent th = new HashMostFrequent();
    assertEquals("a" ,th.mostFrequentHM(th.first));
    assertEquals("it" ,th.mostFrequentHM(th.second));
    assertEquals("summer" ,th.mostFrequentHM(th.third));
  }
}
