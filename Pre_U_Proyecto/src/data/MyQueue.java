package data;

import java.util.ArrayList;

public class MyQueue<E> {

    private Node<E> back;
    private Node<E> front;
    private Integer length;

    public MyQueue(){
        this.back = null;
        this.front = null;
        this.length = 0;
    }

    public void offer(E value){// Esto es enqueue

        Node<E> newNode = new Node<E>(value);
        if(this.length == 0){
            this.back = newNode;
            this.front = newNode;
        }
        else{
            this.back.next = newNode;
            this.back = newNode;
        }
        this.length++;

    }

    public E poll(){// Esto es dequeue

        if(this.length == 0){
            throw new NullPointerException();
        }
        E toReturn = this.front.value;
        this.front = this.front.next;
        this.length--;
        return toReturn;

    }

    public Integer size(){
        return this.length;
    }

    public E peek(){
        return this.front.value;
    }

    public boolean isEmpty(){

        if(this.length == 0){
            return true;
        }
        return false;

    }

    public void clear(){

        this.front = null;
        this.back = null;
        this.length = 0;

    }

    public String toString(){
        if(this.length == 0){
            return "[]";
        }
        String toReturn = "[";
        Node<E> aux = this.front;
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
