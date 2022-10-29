package datastructures.linkedlist;

public class LinkedList<T>
{
  Node<T> head;

  public void insert (T value){
    Node<T> newNode = new Node<>(value);
    newNode.next = this.head;
    this.head = newNode;
  }

  public boolean includes(T value){
    Node<T> current = this.head;
    while (current != null){
      if(current.value.equals(value)) return true;
      current = current.next;
    }
    return false;
  }

  @Override
  public String toString() {
    Node<T> current = this.head;
    StringBuilder string = new StringBuilder();
    while (current != null){
      string.append("{ ").append(current.value).append(" } -> ");
      current = current.next;
    }
    return string + "Null";
  }

  public void endAppend(T value){
    Node<T> current = this.head;
    while(current.next != null){
      current = current.next;
    }
    current.next = new Node<>(value);
  }

  public static void main(String[] args){
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.insert( "world");
    linkedList.insert( "hello");

    System.out.println(linkedList.head.value);
    System.out.println(linkedList.head.next.value);
    System.out.println(linkedList.includes("hi"));
    System.out.println(linkedList);
    linkedList.endAppend("to you");
    System.out.println(linkedList);
  }

}


