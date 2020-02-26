package generics;

import onjava.Tuple2;
import onjava.Tuple3;
import onjava.Tuple4;
import onjava.Tuple5;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:23
 * @describetion:
 */
public class TupleTest {

    static Tuple2 f(){
        return new Tuple2<>("hi",1);
    }

    static Tuple3<Amphibian,String,Integer> g(){
        return new Tuple3<>(new Amphibian(),"hi",46);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String,Integer> tuple2 = f();
        System.out.println(f());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
