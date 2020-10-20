public class MyQueue_CircurArray<E> {

    private E[] array;
    private Integer start;
    private Integer end;
    private Integer capacity;
    private Integer length;

    public MyQueue_CircurArray() {
        this.array = (E[]) new Object[5];
        this.start = 0;
        this.end = 0;
        this.capacity = 5;
        this.length = 0;
    }

    public void offer(E value) {// Esto es enqueue

        if (this.end == this.capacity && this.start > 0) {
            this.array[0] = value;
            this.end = 1;
        } else if (this.end == this.capacity && this.start == 0) {
            resize();
            this.array[this.end++] = value;
        } else if (this.end == this.start && this.length > 0) {
            resize();
            this.array[this.end++] = value;
        } else {
            this.array[this.end++] = value;
        }
        this.length++;

    }

    public E poll() {// Esto es dequeue

        if (this.length == 0) {
            throw new NullPointerException();
        } else if (this.start == this.capacity - 1) {
            E toReturn = this.array[this.start];
            this.start = 0;
            this.length--;
            return toReturn;
        } else {
            E toReturn = this.array[this.start++];
            this.length--;
            return toReturn;
        }

    }

    public Integer size() {
        return this.length;
    }

    public E peek() {
        return this.array[this.start];
    }

    public boolean isEmpty() {

        if (this.length == 0) {
            return true;
        }
        return false;

    }

    public void clear() {

        this.start = 0;
        this.end = 0;
        this.length = 0;

    }

    private void resize() {
        E[] newArray = (E[]) new Object[10 * this.length];
        Integer cont = this.start;
        if (this.end <= this.start) {
            for (int i = 0; i < this.capacity - this.start; i++)
                newArray[i] = this.array[cont++];
            cont = 0;
            for (int i = this.capacity - this.start; i < this.length; i++)
                newArray[i] = this.array[cont++];
        } else {
            for (int i = 0; i < this.length; i++)
                newArray[i] = this.array[cont++];
        }
        this.start = 0;
        this.end = this.length;
        this.capacity *= 10;
        this.array = newArray;
    }

    public String toString() {
        if (this.length == 0) {
            return "[]";
        }
        String toReturn = "[";
        if (this.end <= this.start) {
            for (int i = this.start; i < this.length; i++) {
                toReturn = toReturn.concat(this.array[i] + ", ");

            }
            for (int i = 0; i < this.end - 1; i++) {
                toReturn = toReturn.concat(this.array[i] + ", ");

            }
        } else {
            for (int i = this.start; i < this.end - 1; i++) {
                toReturn = toReturn.concat(this.array[i] + ", ");

            }
        }
        toReturn = toReturn.concat(this.array[this.end - 1] + "]");
        return toReturn;
    }

}

class Main {

    public static void main(String[] args) {

        MyQueue_CircurArray<String> intArrs = new MyQueue_CircurArray<>();
        intArrs.offer("primeroxd");
        intArrs.offer("segundo");
        intArrs.offer("tercero");
        intArrs.offer("cuarto");
        System.out.println(intArrs);
        System.out.println(intArrs.peek());
        System.out.println(intArrs.poll());
        System.out.println(intArrs);
        intArrs.offer("quinto");
        intArrs.offer("sexto");
        System.out.println(intArrs);
        System.out.println(intArrs.size());
        intArrs.offer("septimo");
        intArrs.offer("octavo");
        System.out.println(intArrs);
        System.out.println(intArrs.size());
        System.out.println(intArrs.isEmpty());
        intArrs.clear();
        System.out.println(intArrs.isEmpty());

    }

}
