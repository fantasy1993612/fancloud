package typeinfo; /**
 * @author: xiangming
 * @date: 2020/02/12 00:54
 * @describetion:
 */
import java.util.Random;

class Initable {
    /**
     * 如果一个 static final
     * 值是“编译期常量”（如 Initable.staticFinal），
     * 那么这个值不需要对 Initable 类进行初始化就可以被读取。
     */
    static final int STATIC_FINAL = 47;
    /**
     * 但是，如果只是将一个字段设置成为 static 和 final，
     * 还不足以确保这种行为。例如，对 Initable.staticFinal2
     * 的访问将强制进行类的初始化，因为它不是一个编译期常量
     */
    static final int STATIC_FINAL2 =
            ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    /**
     * 如果一个 static 字段不是 final 的，那么在对它访问时，
     * 总是要求在它被读取之前，要先进行链接（为这个字段分配存储空间）
     * 和初始化（初始化该存储空间），
     * 就像在对 Initable2.staticNonFinal 的访问中所看到的那样。
     */
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

// typeinfo/GenericClassReferences.java

class GenericClassReferences {
    public static void main(String[] args) {
        /**
         * Class 引用总是指向某个 Class 对象，
         * 而 Class 对象可以用于产生类的实例，
         * 并且包含可作用于这些实例的所有方法代码。
         * 它还包含该类的 static 成员，因此 Class
         * 引用表明了它所指向对象的确切类型，而该对象便是
         * Class 类的一个对象。我们可以使用泛型对 Class
         * 引用所指向的 Class 对象的类型进行限定。
         * 在下面的实例中，两种语法都是正确的：
         */
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // 同一个东西
        intClass = double.class;
        // genericIntClass = double.class; // 非法
        /**
         * ? 表示通配符
         * 向 Class 引用添加泛型语法的原因
         * 只是为了提供编译期类型检查，因此如果你操作有误，
         * 稍后就会发现这点。使用普通的 Class 引用你要确保
         * 自己不会犯错，因为一旦你犯了错误，就要等到运行时
         * 才能发现它，很不方便。
         */
        Class<? extends Number> geenericNumberClass = Integer.TYPE;

    }
}


public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        //不会引发初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL);
        // Does trigger initialization:
        System.out.println(Initable.STATIC_FINAL2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.fantasy.eurekaclient.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

