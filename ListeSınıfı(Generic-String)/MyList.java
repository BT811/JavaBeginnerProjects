import java.util.Arrays;

public class MyList <T>{
    int size;
    int capacity;
    T[] array;

    public  MyList(){
        this.capacity = 10;
        this.array = (T[]) new Object[this.capacity];
    }
    public MyList(int capacity){
        this.capacity = capacity;
        this.array =  (T[]) new Object[this.capacity];
    }

    public int size() {
        int count = 0;
        for (T element : array) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }
    public void add(T data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                break;
            } else if (array[i] != null && i == array.length - 1) {
                array =  Arrays.copyOf(array, this.capacity *2);
                setCapacity(this.capacity*2);
                array[array.length / 2] = data;
                break;
            }
        }
    }
    public T get(int index){
        if(index > this.capacity-1 || index < 0){
            return null;
        }else{
            return  array[index];
        }

    }
    public boolean remove(int index){
        if(index > this.capacity || index < 0){
            return false;
        }else{
            for(int i = index-1 ; i < this.array.length-1 ; i++){
                this.array[i] = this.array[i+1];
            }
        }
        return true;
    }
    public T set(int index, T data){
        if(index > this.capacity || index < 0){
            return null;
        }
        T oldData = array[index];
        array[index] = data;
        return oldData ;
        
    }
    public String toString(){

        if( size() == 0){
            return "[]";
        }
        System.out.print("[");

        for(int i = 0 ; i < size() ; i++){
            if(i == size()-1){
                System.out.print(this.array[i]);
            }
            else{
            System.out.print(this.array[i]+",");
            }
        }
        return "]";
    }

    public int indexOf(T data){
        for(T a : this.array){
            int index = 0;
            index++;

            if(data == a ){
                return index;
            }
        }
        return -1;
    }

     int lastIndexOf(T data){

    for(int i = size()-1 ; i >= 0; i--){
        if(data == this.array[i])return i;
    }
    return -1;

    }

    boolean isEmpty(){
        if(size() == 0){

            return true;
        }
        return  false;
    }

    public T[] toArray() {
        return Arrays.copyOfRange(array, 0, size());
    }

    public void clear() {
        this.array = (T[]) new Object[this.capacity];
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> newList = new MyList<>((finish - start + 1));
        for (int i = start; i <= finish; i++) {
            newList.add(array[i]);
        }
        return newList;
    }

    boolean contains(T data){
        for(T a : this.array){
            if(a == data) return true;
        }
        return false;

    }





    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
