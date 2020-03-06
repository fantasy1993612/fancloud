package com.fantasy.unionfind;

/**
 * @author: xiangming
 * @date: 2020/03/01 22:14
 * @describetion: 快速合并 不同的集合
 */
public class QuickUnionDs implements DisjoinSets{

    private int[] parent;

    /**
     * 初始化 每个元素都是根节点标记-1
     * @param N
     */
    public QuickUnionDs(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    /**
     * 连接两个点，找到这两个点的父母 把其中一个节点改为另外一个根节点的值
     * @param p
     * @param q
     */
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        parent[i] = j;
    }

    /**
     * 判断两个节点是否连接，根节点相同即可 O（n）
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnect(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 查找一个节点根节点 O(n)
     * @param p
     * @return
     */
    private int find(int p){
        int r = p;
        if(parent[r] >=0){
            r = parent[r];
        }
        return r;
    }

}
