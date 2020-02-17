package com.fantasy;

/**
 * @Author: xiangming
 * @Date: 2020-02-09-20:15
 * @Describetion: 数组List
 */
public class AList<E> {

    /**
     * 扩容倍数
     */
    private static int RFACTOR = 2;
    /**
     * 初始化大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 保存内容的数组
     */
    private Object[] items;
    /**
     * 数组大小
     */
    private int size;

    /**
     * 构造函数初始化数组和长度
     */
    public AList() {
        items = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 添加一个元素
     *
     * @param x
     */
    public void addLast(int x) {
        //满了就扩容
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = x;
        size += 1;
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return (E) items[size - 1];
    }

    /**
     * 返回数组中第i个元素
     *
     * @param i
     * @return
     */
    public E get(int i) {
        return (E) items[i];
    }

    /**
     * 返回数组大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 删除最后一个节点，只需要，把访问size-1即可
     *
     * @return
     */
    public E removeLast() {
        E x = getLast();
        //java 垃圾回收把里面的对象回收
        items[size - 1] = null;
        size = size - 1;
        return x;
    }

    /**
     * 数组扩容
     */
    public void resize(int capacity) {
        Object[] resizeArray = new Object[capacity];
        System.arraycopy(items, 0, resizeArray, 0, size);
        items = resizeArray;
    }

}
