package data;

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