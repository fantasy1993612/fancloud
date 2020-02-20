package com.fantasy;


/**
 * @author: xiangming
 * @date: 2020/02/12 19:39
 * @describetion:
 */
public class ArrayMap<K,V> {

    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap(){
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    private int keyIndex(K key){
        for(int i = 0; i < size ; i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key){
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K k,V v){
        int index = keyIndex(k);
        if(index == -1){
            keys[size] = k;
            values[size] = v;
            size++;
            return;
        }
        values[index] = v;
    }

    public V get(K k){
        return values[keyIndex(k)];
    }

    public int size(){
        return size;
    }



}
