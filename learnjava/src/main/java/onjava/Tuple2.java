package onjava;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:13
 * @describetion:
 */
public class Tuple2<A,B> {

    public final A a1;

    public final B a2;

    public Tuple2(A a,B b){
        a1 = a;
        a2 = b;
    }

    public String rep() { return a1 + ", " + a2; }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}
