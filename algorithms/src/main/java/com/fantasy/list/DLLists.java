package com.fantasy.list;/**
 * @Auther: xiangming
 * @Date: 2020/2/6 00:16
 * @Description:
 */

/**
 * @Auther: xiangming
 * @Date: 2020/2/6 00:16
 * @Description:
 */
public class DLLists<T> {

    private static class Node<T> {
        public T item;
        public Node next;

        Node(T first, Node intList) {
            this.item = first;
            this.next = intList;
        }
    }

    public DLLists() {
        first = null;
        last = null;
        size = 0;
    }

    private Node first;
    private Node last;
    private int size;

    DLLists(int x) {
        this.first = new Node(x, null);
        last = first;
    }

    public static void main(String[] args) {
        DLLists<Integer> l = new DLLists<>(10);
        l.addFirst(5);
        l.addFirst(290);
    }

    public void addFirst(int x) {
        size++;
        this.first = new Node(x, this.first);
        first = last;
    }

    public T getFirst() {
        return (T)first.item;
    }

    public void addLast(int x){
        size += 1;
        last.next = new Node(x,null);
        last = last.next;
    }

    public int cacheSize(){
        return size;
    }


    private static int size(Node node){
        if(node.next == null){
            return 1;
        }

        return 1+size(node.next);
    }

    public int size(){
        return size(first);
    }
}
