package datastructures.linkedlist;

import org.w3c.dom.ls.LSOutput;

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

  public void insertBefore(T relValue, T newValue) {
    Node<T> current = this.head;
    if(current.value == relValue) insert(newValue);
    else{
      while(current.next != null){
        if (current.next.value.equals(relValue)){
          Node<T> newNode = new Node<>(newValue);
          newNode.next = current.next;
          current.next = newNode;
          break;
        }
        current = current.next;
      }
      if(current.next == null) throw new IllegalArgumentException("Relative value does not exist");
    }
  }

  public void insertAfter(T relValue, T newValue) {
    Node<T> current = this.head;
    while(current.next != null){
      if (current.value.equals(relValue)){
        Node<T> newNode = new Node<>(newValue);
        newNode.next = current.next;
        current.next = newNode;
        break;
      }
      current = current.next;
    }
    if(current.value == relValue & current.next == null) {
      endAppend(newValue);
    }
     else if(current.value != relValue & current.next == null){
      throw new IllegalArgumentException("Relative value does not exist");
    }
  }

  //size is the total number of nodes in the linked list. A newly instantiated linked list has a length of zero.
  public int size(){
    Node<T> current = this.head;
    int size = 0;
    while(current != null){
      size++;
      current = current.next;
    }
    return size;
  }

  //n starts at zero, which is located on the head of the linked list
  public T nthValue(int n){
    if (n < 0) throw new IllegalArgumentException("Node does not exist");
    Node <T> current = this.head;
    if (current == null) throw new IllegalArgumentException("The head node does not hava a preset value");
    for (int i = 0; i < n; i++){
      current = current.next;
      if (current == null) throw new IllegalArgumentException("Node does not exist");
    }
    return current.value;
  }

  public T kthFromEnd(int k){
    if (k < 0) throw new IllegalArgumentException("Node does not exist");
    int size = this.size();
    if (k >= size) throw new IllegalArgumentException("Node does not exist");
    int nodeNum = size - k - 1;
    return nthValue(nodeNum);
  }

  public T midNodeValue(){
    int size = this.size();
    int mid = size / 2;
    return this.nthValue(mid);
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


