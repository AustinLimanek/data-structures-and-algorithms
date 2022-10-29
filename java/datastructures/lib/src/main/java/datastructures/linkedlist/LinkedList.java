package datastructures.linkedlist;

public class LinkedList
{
  Node head;

  public void insert ( String value){
    Node newNode = new Node();
    newNode.value = value;
    newNode.next = this.head;
    this.head = newNode;
  }

  public boolean includes(String value){
    Node current = this.head;
    while (current != null){
      if(current.value.equals(value)) return true;
      current = current.next;
    }
    return false;
  }

  //@Override
  public String toAString() {
    Node current = this.head;
    StringBuilder string = new StringBuilder();
    while (current != null){
      string.append("{ ").append(current.value).append(" } -> ");
      current = current.next;
    }
    return string + "Null";
  }

  public static void main(String[] args){
    LinkedList linkedList = new LinkedList();
    linkedList.insert( "hello");
    linkedList.insert( "world");

    System.out.println(linkedList.head.value);
    System.out.println(linkedList.head.next.value);
    System.out.println(linkedList.includes("hi"));
    System.out.println(linkedList.toAString());
  }
}


