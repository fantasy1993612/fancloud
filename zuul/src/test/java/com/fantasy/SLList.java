package com.fantasy;/**
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

    public IntNode first;

    SLList(int x){
        this.first = new IntNode(x,null);
    }

    public static void main(String[] args) {
        SLList  l = new SLList(10);
        l.addFirst(5);
        l.addFirst(290);
    }

    public void addFirst(int x){
        this.first = new IntNode(x,this.first);
    }

    public int getFirst(){
        return first.item;
    }
}
