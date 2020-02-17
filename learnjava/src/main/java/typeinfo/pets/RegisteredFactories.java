package typeinfo.pets;

/**
 * @author: xiangming
 * @date: 2020/02/16 23:41
 * @describetion:
 */
// typeinfo/RegisteredFactories.java
// 注册工厂到基础类
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 从 Pet 层次结构生成对象的问题是，每当向层次结构中添加
 * 一种新类型的 Pet 时，必须记住将其添加到 LiteralPetCreator.java 的条目中。
 * 在一个定期添加更多类的系统中，这可能会成为问题。
 * 你可能会考虑向每个子类添加静态初始值设定项，因此初始值设定项会将其类添加到某个列表中。
 * 不幸的是，静态初始值设定项仅在首次加载类时调用，因此存在鸡和蛋的问题：生成器的列表中没有类，
 * 因此它无法创建该类的对象，因此类不会被加载并放入列表中。
 * 基本上，你必须自己手工创建列表（除非你编写了一个工具来搜索和分析源代码，然后创建和编译列表）。
 * 所以你能做的最好的事情就是把列表集中放在一个明显的地方。层次结构的基类可能是最好的地方。
 * 我们在这里所做的另一个更改是使用工厂方法设计模式将对象的创建推迟到类本身。
 * 工厂方法可以以多态方式调用，并为你创建适当类型的对象。事实证明，java.util.function.Supplier
 * 用 T get() 描述了原型工厂方法。协变返回类型允许 get() 为 Supplier 的每个子类实现返回不同的类型。
 * 在本例中，基类 Part 包含一个工厂对象的静态列表，列表成员类型为 Supplier<Part>。
 * 对于应该由 get() 方法生成的类型的工厂，通过将它们添加到 prototypes 列表向基类“注册”。
 * 奇怪的是，这些工厂本身就是对象的实例。此列表中的每个对象都是用于创建其他对象的原型：
 * 并非层次结构中的所有类都应实例化；这里的 Filter 和 Belt 只是分类器，
 * 这样你就不会创建任何一个类的实例，而是只创建它们的子类（请注意，如果尝试这样做，你将获得 Part 基类的行为）。
 * 因为 Part implements Supplier<Part>，Part 通过其 get() 方法供应其他 Part。
 * 如果为基类 Part 调用 get()（或者如果 generate() 调用 get()），
 * 它将创建随机特定的 Part 子类型，每个子类型最终都从 Part 继承，并重写相应的 get() 以生成它们中的一个。
 */
class Part implements Supplier<Part> {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Supplier<? extends Part>> prototypes =
            Arrays.asList(
                    new FuelFilter(),
                    new AirFilter(),
                    new CabinAirFilter(),
                    new OilFilter(),
                    new FanBelt(),
                    new PowerSteeringBelt(),
                    new GeneratorBelt()
            );

    private static Random rand = new Random(47);

    @Override
    public Part get() {
        int n = rand.nextInt(prototypes.size());
        return prototypes.get(n).get();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    @Override
    public FuelFilter get() {
        return new FuelFilter();
    }
}

class AirFilter extends Filter {
    @Override
    public AirFilter get() {
        return new AirFilter();
    }
}

class CabinAirFilter extends Filter {
    @Override
    public CabinAirFilter get() {
        return new CabinAirFilter();
    }
}

class OilFilter extends Filter {
    @Override
    public OilFilter get() {
        return new OilFilter();
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    @Override
    public FanBelt get() {
        return new FanBelt();
    }
}

class GeneratorBelt extends Belt {
    @Override
    public GeneratorBelt get() {
        return new GeneratorBelt();
    }
}

class PowerSteeringBelt extends Belt {
    @Override
    public PowerSteeringBelt get() {
        return new PowerSteeringBelt();
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(10)
                .forEach(System.out::println);
    }
}

