/**
 * @Auther: xiangming
 * @Date: 2020/2/20 17:39
 * @Description:
 */
// typeinfo/HiddenImplementation.java
// Sneaking around package hiding

import typeinfo.interfacea.*;
import typeinfo.packageaccess.*;

import java.lang.reflect.*;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
        /* if(a instanceof C) {
            C c = (C)a;
            c.g();
        } */
        // Oops! Reflection still allows us to call g():
        /**
         *
         * 正如你所看到的，通过使用反射，仍然可以调用所有方法，甚至是 private 方法！
         * 如果知道方法名，你就可以在其 Method 对象上调用 setAccessible(true)，就像在 callHiddenMethod()
         * 中看到的那样。你可能觉得，可以通过只发布编译后的代码来阻止这种情况，
         * 但其实这并不能解决问题。因为只需要运行 javap（一个随 JDK 发布的反编译器）即可突破这一限制。
         * 下面是一个使用 javap 的命令行：javap -private C
         */
        callHiddenMethod(a, "g");
        // And even less accessible methods!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
