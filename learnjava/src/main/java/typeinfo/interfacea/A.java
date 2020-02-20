package typeinfo.interfacea;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 17:35
 * @Description:
 */
/**
 *
 * interface 关键字的一个重要目标就是允许程序员隔离组件，
 * 进而降低耦合度。使用接口可以实现这一目标，但是通过类型信息，
 * 这种耦合性还是会传播出去——接口并不是对解耦的一种无懈可击的保障。比如我们先写一个接口：
 */
public interface A {
    void f();
}

