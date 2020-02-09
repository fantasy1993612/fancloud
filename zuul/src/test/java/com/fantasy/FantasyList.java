package com.fantasy;

public interface FantasyList<E> {

    public void addFirst(E x);

    public void addLast(E y);

    public E getFirst();

    public E getLast();

    public E removeLast();

    public E get(int i);

    public void insert(E x, int position);

    public int size();

}
