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

abstract class List<E>{

    abstract void insert(E e);
    abstract void delete(E e);
    abstract E getAtIndex(Integer index);
    abstract Integer getIndexOf(E e);
    abstract E getFirst();
    abstract E getLast();
    abstract void deleteFirst();
    abstract void deleteLast();
    abstract boolean isEmpty();
    abstract Integer length();
    abstract void insertAt(Integer index, E e);
    abstract void deleteAt(Integer index);
    abstract boolean contains(E value);

}

public class DoubleLinkedList<E> extends List<E>{

    Node<E> first;
    Node<E> last;
    Integer size;

    public DoubleLinkedList(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    void insert(E e) {
        Node<E> aux = new Node<>(e);
        if(this.size == 0){
            this.first = aux;
        }
        else {
            this.last.next = aux;
            aux.prev = this.last;
        }
        this.last = aux;
        this.size++;
    }

    @Override
    void delete(E e) {

        if(this.size == 0){
            System.out.println("Lista vacia");
        }
        else if(!(this.contains(e))){
            System.out.println("El elemento no se encuentra en la lista");
        }
        else{
            Node<E> aux = this.first;
            while(!(aux.value.equals(e))){
                aux = aux.next;
            }
            if(!(aux.equals(this.first) || aux.equals(this.last))){
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
            }
            else if(aux.equals(this.first) && aux.equals(this.last)){
                this.first = null;
                this.last = null;
            }
            else{
                if(aux.equals(this.first)){
                    this.first = aux.next;
                    aux.next.prev = null;
                }
                else{
                    this.last = aux.prev;
                    aux.prev.next = null;
                }
            }
            this.size--;
        }
    }

    @Override
    E getAtIndex(Integer index) {
        if(this.size == 0){
            System.out.println("Lista vacia");
            return null;
        }
        else if(index >= this.size || index < 0){
            System.out.println("Error null pointer");
            return null;
        }
        else{
            Node<E> aux = this.first;
            int cont = 0;
            while(cont != index){
                aux = aux.next;
                cont++;
            }
            return aux.value;
        }
    }

    @Override
    Integer getIndexOf(E e) {
        if(this.size == 0){
            System.out.println("Lista vacia");
            return -1;
        }
        else if(!(this.contains(e))){
            System.out.println("El elemento no se encuentra en la lista");
            return -1;
        }
        else{
            int cont = 0;
            Node<E> aux = this.first;
            while(!(aux.value.equals(e))){
                cont++;
                aux = aux.next;
            }
            return cont;
        }
    }

    @Override
    E getFirst() {
        return first.value;
    }

    @Override
    E getLast() {
        return last.value;
    }

    @Override
    void deleteFirst() {
        this.first = this.first.next;
    }

    @Override
    void deleteLast() {
        this.last = this.last.prev;
    }

    @Override
    boolean isEmpty() {
        return false;
    }

    @Override
    Integer length() {
        return size;
    }

    @Override
    void insertAt(Integer index, E e) {
        if(index >= this.size || index < 0){
            System.out.println("Null pointer o lista vacia");
        }
        else{
            int cont = 0;
            Node<E> aux = this.first;
            Node<E> inNod = new Node<>(e);
            while(cont != index){
                cont++;
                aux = aux.next;
            }
            if(aux.prev != null && aux.next != null){
                aux.prev.next = inNod;
                aux.prev = inNod;
                inNod.prev = aux.prev;
                inNod.next = aux;
            }
            else if(index == 0){
                inNod.next = this.first;
                this.first.prev = inNod;
                this.first = inNod;
            }
            else{
                inNod.prev = aux.prev;
                aux.prev.next = inNod;
                inNod.next = aux;
                aux.prev = inNod;
            }
            this.size++;
        }
    }

    @Override
    void deleteAt(Integer index) {
        if(index >= this.size || index < 0){
            System.out.println("Null pointer o lista vacia");
        }
        else{
            int cont = 0;
            Node<E> aux = this.first;
            while(cont != index){
                cont++;
                aux = aux.next;
            }
            if(index != 0 && index != this.size-1){
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
            }
            else if(index == 0){
                aux.next.prev = null;
                this.first = aux.next;
            }
            else{
                aux.prev.next = null;
                this.last = aux.prev;
            }
            this.size--;
        }
    }

    @Override
    boolean contains(E value){
        if(this.size == 0){
            System.out.println("Lista vacia");
            return false;
        }
        boolean isIn = false;
        boolean flag = false;
        Node<E> aux = this.first;
        while(!(flag) && aux != null){
            if(aux.value.equals(value)){
                flag = true;
                isIn = true;
            }
            aux = aux.next;
        }
        return isIn;
    }

    @Override
    public String toString(){
        if(this.size == 0){
            return "[]";
        }
        else{
            String toReturn = "[";
            Node<E> aux = this.first;
            while(!(aux.equals(this.last))){
                toReturn = toReturn.concat(aux.value.toString()+", ");
                aux = aux.next;
            }
            toReturn = toReturn.concat(this.last.value.toString()+"]");
            return toReturn;
        }
    }

}

class Main {
    public static void main(String[] args) {
        DoubleLinkedList<String> lista1 = new DoubleLinkedList<String>();
        lista1.insert("Hola");
        lista1.insert("ptos");
        lista1.insert("como");
        lista1.insert("estan");
        System.out.println(lista1.toString());
        lista1.insertAt(0,"Bueno");
        System.out.println(lista1.toString());
        lista1.deleteAt(2);;
        System.out.println(lista1.toString());
    }
}
