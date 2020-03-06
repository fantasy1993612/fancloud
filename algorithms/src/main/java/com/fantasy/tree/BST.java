package com.fantasy.tree;

/**
 * @Auther: xiangming
 * @Date: 2020/3/6 23:09
 * @Description: 二叉查找树 左边节点比右边节点大
 */
public class BST<Key> {

    private Key key;
    private BST left;
    private BST right;

    public BST(Key key, BST left, BST Right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

    /**
     * @describtion: 查找二叉树
     * @auther: xiangming
     * @date: 2020/3/6 11:39 PM
     */
    public static <Key extends Comparable<Key>> BST<Key> find(BST<Key> t, Key sk) {
        if (t == null) {
            return null;
        }

        if (sk.equals(t.key)) {
            return t;
        }

        if (sk.compareTo(t.key) < 0) {
            find(t.left, sk);
        }

        if (sk.compareTo(t.key) > 0) {
            find(t.right, sk);
        }

        return t;
    }

    public static <Key extends Comparable<Key>> BST<Key> insert(BST<Key> t, Key ik) {
        if (t == null) {
            return new BST<>(ik);
        }

        if (ik.compareTo(t.key) < 0) {
            t.left = insert(t.left, ik);
        }

        if (ik.compareTo(t.key) > 0) {
            t.right = insert(t.right, ik);
        }

        return t;
    }

    public void delete(BST<Key> t,Key ik){

        if(t == this){
            delete(t.right,ik);
        }


    }


}
