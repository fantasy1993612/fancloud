package com.fantasy.map;

import java.util.List;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 22:22
 * @Description:
 */
public class MapHelper {

    /**
     * static 后<K,V> 是形式参数定义，定义在返回参数前
     */
    public static <K, V> V get(Map61B<K, V> map61B, K key) {
        if (map61B.containsKey(key)) {
            return map61B.get(key);
        }
        return null;
    }

    /**
     * 返回最大key
     * You might be wondering, why does it "extend" comparable and not "implement"? Comparable is an interface after all.
     * Well, it turns out, "extends" in this context has a different meaning than in the polymorphism context.
     * When we say that the Dog class extends the Animal class, we are saying that Dogs can do anything that animals can do
     * and more! We are giving Dog the abilities of an animal. When we say that K extends Comparable, we are simply stating
     * a fact. We aren't giving K the abilities of a Comparable, we are just saying that K must be Comparable. This different
     * use of extends is called type upper bounding. Confusing? That's okay, it is confusing. Just remember, in the context of
     * inheritance, the extends keyword is active in giving the subclass the abilities of the superclass. You can think of it as
     * a fairy Godmother: she sees your needs and helps you out with some of her fairy magic. On the other hand, in the context of
     * generics, extends simply states a fact: You must be a subclass of whatever you're extending. When used with generics
     * (like in generic method headers), extends imposes a constraint rather than grants new abilities. It's akin to a fortune
     * teller, who just tells you something without doing much about it.
     * @describtion: 
     * @auther: xiangming
     * @date: 2020/2/20 10:55 PM
     */
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map61B) {
        List<K> kList = map61B.keys();
        K largest = kList.get(0);
        for (K k : kList) {
            if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }
        return largest;
    }

    public static void testGet() {
        Map61B<String, Integer> map61B = new ArrayMap<String, Integer>();
        map61B.put("horse", 3);
        map61B.put("cock", 4);
        map61B.put("fish", 5);
        Integer a = MapHelper.get(map61B, "fish");
        Integer actual = 4;
    }

    public static void main(String[] args) {
        MapHelper.testGet();
    }
}
