package typeinfo.pets;

import lombok.SneakyThrows;

import java.util.List;
import java.util.function.Supplier;

import static typeinfo.ClassInitialization.rand;

/**
 * @author: xiangming
 * @date: 2020/02/16 22:11
 * @describetion:
 */


class Individual {

    public Individual(String name) {

    }

    public Individual() {

    }
}

class Pet extends Individual {

    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }
}

class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }
}

class Mouse extends Pet {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }
}


/**
 * 抽象的 types() 方法需要子类来实现，
 * 以此来获取 Class 对象构成的 List（这是模板方法设计模式的一种变体）。
 * 注意，其中类的类型被定义为“任何从 Pet 导出的类型”，因此 newInstance()
 * 不需要转型就可以产生 Pet。get() 随机的选取出一个 Class 对象
 * ，然后可以通过 Class.newInstance() 来生成该类的新实例。
 * 在调用 newInstance() 时，可能会出现两种异常。在紧跟 try 语句块后面的
 * catch 子句中可以看到对它们的处理。异常的名字再次成为了一种对错误类型相对
 * 比较有用的解释（IllegalAccessException 违反了 Java 安全机制，在本例中，表示默认构造器为 private 的情况）。
 */
public abstract class PetCreator implements Supplier<Pet> {

    public abstract List<Class<? extends Pet>> types();

    @SneakyThrows
    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());
        return types().get(n).newInstance();
    }
}
