package generics;

import onjava.Tuple2;
import onjava.Tuple3;
import onjava.Tuple4;
import onjava.Tuple5;

/**
 * @author: xiangming
 * @date: 2020/02/26 03:30
 * @describetion:
 */
// onjava/Tuple.java
// Tuple library using type argument inference

public class Tuple {
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C>
    tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D>
    tuple(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static <A, B, C, D, E>
    Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<>(a, b, c, d, e);
    }
}

