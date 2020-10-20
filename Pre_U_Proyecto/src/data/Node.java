package data;

class Node<E>{
    Node prev;
    E value;
    Node next;

    public Node(E value){
        this.prev = null;
        this.value = value;
        this.next = null;
    }
}