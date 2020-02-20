package typeinfo;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 16:39
 * @Description:
 */

import java.util.Optional;

/**
 *
 * 如果你使用内置的 null 来表示没有对象，
 * 每次使用引用的时候就必须测试一下引用是否为 null，这显得有点枯燥，
 * 而且势必会产生相当乏味的代码。问题在于 null 没什么自己的行为，
 * 只会在你想用它执行任何操作的时候产生 NullPointException。
 * java.util.Optional（首次出现是在函数式编程这章）为 null 值提供了一个轻量级代理，
 * Optional 对象可以防止你的代码直接抛出 NullPointException。
 * 虽然 Optional 是 Java 8 为了支持流式编程才引入的，但其实它是一个通用的工具。
 * 为了证明这点，在本节中，我们会把它用在普通的类中。因为涉及一些运行时检测，所以把这一小节放在了本章。
 * 实际上，在所有地方都使用 Optional 是没有意义的，有时候检查一下是不是 null 也挺好的，
 * 或者有时我们可以合理地假设不会出现 null，甚至有时候检查 NullPointException 异常也是可以接受的。
 * Optional 最有用武之地的是在那些“更接近数据”的地方，在问题空间中代表实体的对象上。
 * 举个简单的例子，很多系统中都有 Person 类型，代码中有些情况下你可能没有一个实际的 Person 对象
 * （或者可能有，但是你还没用关于那个人的所有信息）。这时，在传统方法下，你会用到一个 null 引用，
 * 并且在使用的时候测试它是不是 null。而现在，我们可以使用 Optional：
 */
class Person {
    public final Optional<String> first;
    public final Optional<String> last;
    public final Optional<String> address;
    // etc.
    public final Boolean empty;

    Person(String first, String last, String address) {
        this.first = Optional.ofNullable(first);
        this.last = Optional.ofNullable(last);
        this.address = Optional.ofNullable(address);
        empty = !this.first.isPresent()
                && !this.last.isPresent()
                && !this.address.isPresent();
    }

    Person(String first, String last) {
        this(first, last, null);
    }

    Person(String last) {
        this(null, last, null);
    }

    Person() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        if (empty)
            return "<Empty>";
        return (first.orElse("") +
                " " + last.orElse("") +
                " " + address.orElse("")).trim();
    }
    
    /**
     *
     * 如果想使用 Person，就必须使用 Optional 接口才能访问它的 String 字段，
     * 这样就不会意外触发 NullPointException 了。
     */
    public static void main(String[] args) {
        System.out.println(new Person());
        System.out.println(new Person("Smith"));
        System.out.println(new Person("Bob", "Smith"));
        System.out.println(new Person("Bob", "Smith",
                "11 Degree Lane, Frostbite Falls, MN"));
    }
}

