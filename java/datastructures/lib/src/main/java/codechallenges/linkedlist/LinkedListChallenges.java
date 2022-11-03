package codechallenges.linkedlist;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

public class LinkedListChallenges
{
  LinkedList linkedList;

  public LinkedListChallenges()
  {
    linkedList = new LinkedList();
  }

  public static LinkedList<Integer> zipper(LinkedList<Integer> linked1, LinkedList<Integer> linked2){
    Node<Integer> cur1 = linked1.head;
    if(cur1 == null) return linked2;
    Node<Integer> cur2  = linked2.head;
    if(cur2 == null) return linked1;
    Node<Integer> temp = cur2.next;

    while(cur1.next != null && temp !=null){
      cur2.next = cur1.next;
      cur1.next = cur2;
      cur2 = temp;
      temp = cur2.next;
      cur1 = cur1.next.next;
    }
    if(cur1.next == null){
      cur1.next = cur2;
    }
    else{
      cur2.next = cur1.next;
      cur1.next = cur2;
    }
    return linked1;
  }

  public void linkedListChallenge06()
  {

  }
}
