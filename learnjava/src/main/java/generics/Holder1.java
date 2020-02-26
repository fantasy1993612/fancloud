package generics;

/**
 * @author: xiangming
 * @date: 2020/02/26 01:54
 * @describetion:
 * 这个类的可复用性不高，它无法持有其他类型的对象。我们可不希望为碰到的每个类型都编写一个新的类。
 * 在 Java 5 之前，我们可以让这个类直接持有 Object 类型的对象：
 */

class Automobile {
}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

