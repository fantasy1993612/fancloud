package typeinfo;/**
 * @Auther: xiangming
 * @Date: 2020/2/17 19:52
 * @Description:
 */


/**
 * 动态代理
 * 代理是基本的设计模式之一。一个对象封装真实对象，代替其提供其他或不同的操作
 * ---这些操作通常涉及到与“真实”对象的通信，因此代理通常充当中间对象。这是一个简单的示例，显示代理的结构：
 */
interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(
                "SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

/**
 * 因为 consumer() 接受 Interface，所以它不知道获得的是 RealObject 还是
 * SimpleProxy，因为两者都实现了 Interface。 但是，在客户端和 RealObject
 * 之间插入的 SimpleProxy 执行操作，然后在 RealObject 上调用相同的方法。
 * 当你希望将额外的操作与“真实对象”做分离时，代理可能会有所帮助，
 * 尤其是当你想要轻松地启用额外的操作时，反之亦然（设计模式就是封装变更---所以你必须改变一些东西以证明模式的合理性）。
 * 例如，如果你想跟踪对 RealObject 中方法的调用，或衡量此类调用的开销，该怎么办？你不想这部分代码耦合到你的程序中，
 * 而代理能使你可以很轻松地添加或删除它。
 */
class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

