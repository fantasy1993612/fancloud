package com.fantasy.map;

import java.util.List;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 22:23
 * @Description:
 */
public interface Map61B<K,V> {

    void put(K k, V v);

    V get(K k);

    int size();

    boolean containsKey(K k);

    List<K> keys();
}
