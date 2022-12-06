package codechallenges.hashmap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class HashMostFrequent {

  String first = "Once upon a time, there was a brave princess who...";
  String second = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way  in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
  String third = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";

  public String mostFrequentHM(String str){

    HashSet<String> hash = new HashSet<>();

    String newStr = str.replace(",", "").replace(".", "").replace(" - ", "").toLowerCase();

    for (String word : newStr.split(" ")){

      if(hash.contains(word)){
        return word;
      }
      else{
        hash.add(word);
      }
    }

    return "No repeat";
  }


}
