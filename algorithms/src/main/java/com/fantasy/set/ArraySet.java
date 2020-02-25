package com.fantasy.set;

import javax.validation.constraints.NotNull;
import java.util.Iterator;


/**
 * @Auther: xiangming
 * @Date: 2020/2/21 17:38
 * @Description:
 */
public class ArraySet<T> implements Iterable<T> {

    private T[] arrays;

    private int size;

    public ArraySet() {
        arrays = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i = 0 ; i < arrays.length;i++){
            if(x.equals(arrays[i])){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(@NotNull T x) {
        if(contains(x)){
            return;
        }
        arrays[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        //s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
//        Iterator<String>  stringIterator = s.iterator();
//        while(stringIterator.hasNext()){
//            System.out.println(stringIterator.next());
//        }
//
//        for(String m : s){
//            System.out.println(m);
//        }
        System.out.println(s);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }


    private class ArraySetIterator implements Iterator<T>{
        private int wizPos ;

        public ArraySetIterator(){
            wizPos = 0;
        }
        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T item = arrays[wizPos];
            wizPos++;
            return item;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(arrays[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(arrays[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
