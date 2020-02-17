package typeinfo;

/**
 * @author: xiangming
 * @date: 2020/02/12 01:32
 * @describetion:
 */
public class GenericToyTest {
    /**
     * 如果你手头的是超类，那编译期将只
     * 允许你声明超类引用为“某个类，它是
     * FancyToy 的超类”，就像在表达式
     * Class<? super FancyToy> 中所看到的那样。
     * 而不会接收 Class<Toy> 这样的声明。
     * 这看上去显得有些怪，因为 getSuperClass()
     * 方法返回的是基类（不是接口），并且编译器在
     * 编译期就知道它是什么类型了
     * （在本例中就是 Toy.class），
     * 而不仅仅只是"某个类"。不管怎样，
     * 正是由于这种含糊性，up.newInstance
     * 的返回值不是精确类型，而只是 Object。
     */
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up =
                ftClass.getSuperclass();
        // This won't compile:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        Object obj = up.newInstance();
    }
}

