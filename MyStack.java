import java.util.EmptyStackException;

class Node<E> {
    E value;
    Node next;

    public Node(E value){
        this.value = value;
        this.next = null;
    }
}

public class MyStack<E> {

    private Node<E> top;
    private Integer length;

    public MyStack(){
        this.top = null;
        this.length = 0;
    }

    public void push(E value){

        Node<E> newNode = new Node<>(value);
        newNode.next = this.top;
        this.top = newNode;
        this.length++;

    }

    public E pop(){
        if(this.length == 0){
            throw new EmptyStackException();
        }
        E toReturn = this.top.value;
        this.top = this.top.next;
        this.length--;
        return toReturn;
    }

    public E top(){
        return this.top.value;
    }

    public Integer size(){
        return this.length;
    }

    public void clear(){
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        if(this.length == 0){
            return true;
        }
        return false;
    }

    public String toString(){
        if(this.length == 0){
            return "[]";
        }
        String toReturn = "[";
        Node<E> aux = this.top;
        if(aux.value.getClass().equals(toReturn.getClass())){
            toReturn = "[\"";
            while(aux.next != null){
                toReturn = toReturn.concat(aux.value+"\", \"");
                aux = aux.next;
            }
            toReturn = toReturn.concat(aux.value+"\"]");
        }
        else{
            while(aux.next != null){
                toReturn = toReturn.concat(aux.value+", ");
                aux = aux.next;
            }
            toReturn = toReturn.concat(aux.value+"]");
        }
        return toReturn;
    }

}

class Main{

    public static void main(String[] args) {
        MyStack<String> strList = new MyStack<>();
        strList.push("ver");
        strList.push("a");
        strList.push("vamos");
        strList.push("Bueno");
        System.out.println(strList);
        System.out.println(strList.top());
        System.out.println(strList.pop());
        System.out.println(strList);
        System.out.println(strList.isEmpty());
        System.out.println(strList.size());
        strList.clear();
        System.out.println(strList.isEmpty());
    }

}
