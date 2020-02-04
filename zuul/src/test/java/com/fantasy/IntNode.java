package com.fantasy;/**
 * @Auther: xiangming
 * @Date: 2020/2/4 23:54
 * @Description:
 */

/**
 * @Auther: xiangming
 * @Date: 2020/2/4 23:54
 * @Description:
 */
public class IntNode {

    public int item;

    public IntNode next;



    IntNode(int first, IntNode intList){
        this.item = first;
        this.next = intList;
    }

    public static void main(String[] args) {
        IntNode L = new IntNode(5,null);
        L = new IntNode(10,L);
        L = new IntNode(20,L);
        System.out.println(L.iterativeSize()+"");
        System.out.println("");
    }

    /**
     *
     * @describtion: 非递归
     * @auther: 
     * @date: 2020/2/5 12:28 AM
     */
    public int iterativeSize(){
        IntNode L = this;
        int count = 0;
        while(L != null){
            count += 1;
            L = L.next;
        }
        return count;
    }

    /**
     * 递归方式
     * @describtion: 
     * @auther: 
     * @date: 2020/2/5 12:28 AM
     */
    public int size(){
        if(next == null){
            return 1;
        }
        return 1+this.next.size();
    }

    public int getR(int index){
        IntNode L = this;
        int count = 0;
        while(L != null){
            if(count == index){
                return L.item;
            }
            count += 1;
            L = L.next;
        }
        return L.item;
    }

    public int get(int i){
        if(i == 0){
            return item;
        }
        return next.get(i - 1);
    }
}