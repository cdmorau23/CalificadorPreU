public class DynamicArray<E> {

    private E[] array;
    private int size;
    private int capacity;

    public DynamicArray(){
        this.array = (E[]) new Object[2];
        this.size = 0;
        this.capacity = 2;
    }

    public int getSize() {
        return this.size;
    }

    public E getAt(int index){

        if(index >= size || index < 0){
            throw new NullPointerException();
        };
        return this.array[index];

    }

    public void insertAt(int index, E value){

        if(index >= size || index < 0)
            throw new NullPointerException();
        if(this.size == this.capacity)
            this.resize(10);
        for(int i = this.size; i > index; i--)
            this.array[i] = this.array[i-1];
        this.array[index] = value;
        this.size++;

    }

    public void add(E value){ //PUSHBACK

        if(this.size == this.capacity) this.resize(2);
        this.array[this.size++] = value;

    }

    public void setAt(int index, E value){

        if(index >= size || index < 0)
            throw new NullPointerException();
        this.array[index] = value;

    }

    /*public void deleteAt(int index){
        
        if(index >= size || index < 0){
            throw new NullPointerException();
        }
        E[] newArray = (E[]) new Object[this.capacity];
        for(int i = 0; i < index; i++)
            newArray[i] = this.array[i];
        for (int j = index+1; j < this.size;j++)
            newArray[j-1] = this.array[j];
        this.array = newArray;
        this.size--;
        
    }*/

    public void deleteAt(int index){
        
        if(index >= size || index < 0){
            throw new NullPointerException();
        }
        for(int i = index; i < this.size-1; i++){
            this.array[i] = this.array[i+1];
        }
        this.array[--this.size] = null;
        
    }

    public boolean contains(E value){
        Integer cont = 0;
        E aux = this.array[cont];
        while(aux != value && cont < this.size){
            cont++;
            aux = this.array[cont];
        }
        if(aux == value){
            return true;
        }
        return false;
    }

    public void delete(E value){

        if(this.size == 0){
            throw new NullPointerException();
        }

        Integer cont = 0;
        E aux = this.array[cont];
        while(aux != value && cont < this.size){
            cont++;
            aux = this.array[cont];
        }
        if(aux == value){
            deleteAt(cont);
        }
        else{
            throw new NullPointerException();
        }

    }

    private void resize(int mult){
        
        E[] newArray = (E[]) new Object[mult*this.size];
        for(int i = 0; i < this.size; i++)
            newArray[i] = this.array[i];
        this.capacity *= mult;
        this.array = newArray;
        
    }

    public String toString(){
        
        if(this.size == 0){
            return "[]";
        }
        String toReturn = "[";
        for(int i = 0; i < this.size-1; i++){
            toReturn = toReturn.concat(this.array[i]+", ");

        }
        toReturn = toReturn.concat(this.array[this.size-1]+"]");
        return toReturn;
    }

}

class Main{
    public static void main(String[] args) {
        DynamicArray<String> arr2 = new DynamicArray<>();

        arr2.add("uno");
        arr2.add("dos");
        arr2.add("tres");
        arr2.add("cuatro");
        arr2.add("cinco");
        arr2.insertAt(4, "cuatro y medio xd");
        System.out.println(arr2);
        arr2.deleteAt(0);
        System.out.println(arr2.contains("tres"));
        System.out.println(arr2);
        arr2.deleteAt(0);
        System.out.println(arr2);
        arr2.deleteAt(0);
        arr2.deleteAt(0);
        arr2.delete("cinco");
        System.out.println(arr2);

    }
}
