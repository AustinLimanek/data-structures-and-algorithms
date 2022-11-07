package datastructures.linkedlist;

public class LinkedList<T>
{
  public Node<T> head = null;

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

  public Node<T> cyclicLinkedList(){
    Node<T> slow = this.head;
    Node<T> fast = this.head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) break;
    }

    if(fast == null || fast.next == null) return null;

    slow = this.head;
    while(slow != fast){
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }

  public Node<T> intersectionLinkedLists(LinkedList<T> linkedList){
    int diff = this.size() - linkedList.size();
    int skip = Math.abs(diff);
    Node<T> big = this.head;
    Node<T> small = linkedList.head;
    if (diff < 0){
      big = linkedList.head;
      small = this.head;
    }
    for(int i = 0; i < skip; i++){
      big = big.next;
    }
    while(big.next != small.next){
      big = big.next;
      small = small.next;
    }
    return big.next;
  }

  public int addition (int a, int b){
    if(b == 0) return a;
    int sum = a ^ b;
    int carry = (a & b) << 1;
    return addition(sum, carry);
  }

}


