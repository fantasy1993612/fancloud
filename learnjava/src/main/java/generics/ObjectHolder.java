package generics;

/**
 * @author: xiangming
 * @date: 2020/02/26 01:55
 * @describetion:
 * 现在，ObjectHolder 可以持有任何类型的对象，在上面的示例中，一个 ObjectHolder 先后持有了三种不同类型的对象。
 */

public class ObjectHolder {
    private Object a;

    public ObjectHolder(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1); // 自动装箱为 Integer
        Integer x = (Integer) h2.get();
    }
}
