package typeinfo.pets;

/**
 * @author: xiangming
 * @date: 2020/02/16 22:54
 * @describetion:
 */
// typeinfo/pets/LiteralPetCreator.java
// 使用类字面量
// {java typeinfo.pets.LiteralPetCreator}
import java.util.*;

public class LiteralPetCreator extends PetCreator {

    // try 代码块不再需要
    public static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class,Mouse.class,Cat.class));

    // 用于随机创建的类型:
    private static final List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Pet.class),
                    ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}

