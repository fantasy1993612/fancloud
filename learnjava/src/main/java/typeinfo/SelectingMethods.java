package typeinfo;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 16:33
 * @Description:
 */
import java.lang.reflect.*;

/**
 *
 * 通常执行代理操作，然后使用 Method.invoke()
 * 将请求转发给被代理对象，并携带必要的参数。这在一开始看起来是有限制的，
 * 好像你只能执行一般的操作。但是，可以过滤某些方法调用，同时传递其他方法调用：
 * 在这个示例里，我们只是在寻找方法名，但是你也可以寻找方法签名的其他方面，甚至可以搜索特定的参数值。
 */
class MethodSelector implements InvocationHandler {
    private Object proxied;

    MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if (method.getName().equals("interesting"))
            System.out.println(
                    "Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

class Implementation implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}

class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy =
                (SomeMethods) Proxy.newProxyInstance(
                        SomeMethods.class.getClassLoader(),
                        new Class[]{ SomeMethods.class },
                        new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}

