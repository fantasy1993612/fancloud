package typeinfo.pets;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author: xiangming
 * @date: 2020/02/16 23:11
 * @describetion:
 */

public class PetCount3 {

    /**
     * Class.isInstance() 方法提供了一种动态测试
     * 对象类型的方法。因此，所有这些繁琐的 instanceof
     * 语句都可以从 PetCount.java 中删除：
     */

    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {

//        Counter() {
//            super(LiteralPetCreator.ALL_TYPES.stream()
//                    .map(lpc -> Pair(lpc, 0))
//                    .collect(Collectors.toMap(Pair::key,Pair::value)));
//        }

        public void count(Pet pet) {
            // Class.isInstance() 替换 instanceof:
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair ->
                            put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s",
                            pair.getKey().getSimpleName(),
                            pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        Pets.stream()
                .limit(20)
                .peek(petCount::count)
                .forEach(p -> System.out.print(
                        p.getClass().getSimpleName() + " "));
        System.out.println("n" + petCount);
    }
}
