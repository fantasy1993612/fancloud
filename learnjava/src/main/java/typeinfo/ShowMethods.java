package typeinfo;/**
/**
 * @Auther: xiangming
 * @Date: 2020/2/17 19:45
 * @Description:
 */
// typeinfo/ShowMethods.java
// 使用反射展示一个类的所有方法，甚至包括定义在基类中方法
import java.lang.reflect.*;
import java.util.regex.*;

/**
 * 类 Class 支持反射的概念， j
 * ava.lang.reflect 库中包含类 Field、Method 和
 * Constructor（每一个都实现了 Member 接口）。这些类型的对象由 JVM
 * 在运行时创建，以表示未知类中的对应成员。然后，可以使用 Constructor 创建新对象，
 * get() 和 set() 方法读取和修改与 Field 对象关联的字段，invoke() 方法调用与
 * Method 对象关联的方法。此外，还可以调用便利方法 getFields()、getMethods()、
 * getConstructors() 等，以返回表示字段、方法和构造函数的对象数组。（你可以通过在 JDK 文档中查找类 Class 来了解更多信息。）
 * 因此，匿名对象的类信息可以在运行时完全确定，编译时不需要知道任何信息。
 * 重要的是要意识到反射没有什么魔力。当你使用反射与未知类型的对象交互时，
 * JVM 将查看该对象，并看到它属于特定的类（就像普通的 RTTI）。在对其执行任何操作之前，
 * 必须加载 Class 对象。因此，该特定类型的 .class 文件必须在本地计算机上或通过网络对
 * JVM 仍然可用。因此，RTTI 和反射的真正区别在于，使用 RTTI 时，编译器在编译时会打开并检查
 * .class 文件。换句话说，你可以用“正常”的方式调用一个对象的所有方法。通过反射，
 * .class 文件在编译时不可用；它由运行时环境打开并检查。
 */
public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println(usage);
//            System.exit(0);
//        }
        int lines = 0;
        try {
            Class<?> c = Class.forName("typeinfo.pets.Pets");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(
                            p.matcher(
                                    method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                    System.out.println(
                            p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(
                                method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(
                                ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}

