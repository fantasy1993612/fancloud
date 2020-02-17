package com.fantasy.list;/**
 * @Auther: xiangming
 * @Date: 2020/2/5 01:02
 * @Description:
 */

/**
 * @Auther: xiangming
 * @Date: 2020/2/5 01:02
 * @Description:
 */
public class SLList {

    private static class Node {
        public int item;
        public Node next;

        Node(int first, Node intList) {
            this.item = first;
            this.next = intList;
        }
    }

    public SLList() {
        first = null;
        size = 0;
    }

    private Node first;
    private int size;

    SLList(int x) {
        this.first = new Node(x, null);
    }

    public static void main(String[] args) {
        SLList l = new SLList(10);
        l.addFirst(5);
        l.addFirst(290);
    }

    public void addFirst(int x) {
        size++;
        this.first = new Node(x, this.first);
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x){
        size += 1;
        Node node = first;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(x,null);
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
