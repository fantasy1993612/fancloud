package com.fantasy.unionfind;

/**
 * @author: xiangming
 * @date: 2020/03/01 21:38
 * @describetion: 查并集接口
 */
public interface DisjoinSets {

    /**
     * 连接两个节点
     * @param p
     * @param q
     */
    void connect(int p, int q);

    /**
     * 两个节点是否连接
     * @param p
     * @param q
     * @return
     */
    boolean isConnect(int p, int q);
}
