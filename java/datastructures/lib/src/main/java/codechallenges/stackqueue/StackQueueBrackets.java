package codechallenges.stackqueue;

import java.lang.reflect.Array;

public class StackQueueBrackets {

  public static boolean bracketValidation(String input){
    PseudoQueue<String> validate = new PseudoQueue<>();
    String[] string = input.split("");
    String[] closed = new String[]{"}", ")", "]"};
    String openString = "{([";
    String closedString = "})]";

    for (String l : string){
      if(openString.contains(l)){
        validate.getRight().push(closed[openString.indexOf(l)]);
      }
      else if(closedString.contains(l)) {
        if (validate.getRight().isEmpty()) {
          return false;
        }
        else if(validate.getRight().peek().equals(l)){
          validate.getRight().pop();
        }
        else{return false;}
      }
      validate.getLeft().push(l);
    }

    if(validate.getRight().isEmpty()){
      return true;
    }
    return false;
  }

}
