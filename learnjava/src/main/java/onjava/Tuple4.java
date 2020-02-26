package onjava;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:21
 * @describetion:
 */
public class Tuple4<A, B, C, D>
        extends Tuple3<A, B, C> {
    public final D a4;
    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        a4 = d;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a4;
    }
}