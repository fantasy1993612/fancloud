package generics.coffee;

import lombok.SneakyThrows;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:51
 * @describetion:
 */
public class CoffeeSupplier implements Supplier<Coffee> , Iterable<Coffee>{

    private Class<?>[] types = { Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class };

    private static Random rand = new Random(47);
    public CoffeeSupplier() {}
    // For iteration:
    private int size = 0;
    public CoffeeSupplier(int sz) { size = sz; }


    @Override
    @SneakyThrows
    public Coffee get() {
        return (Coffee) types[rand.nextInt(types.length)].newInstance();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() { return count > 0; }
        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier())
                .limit(5)
                .forEach(System.out::println);
        for (Coffee c : new CoffeeSupplier(5)) {
            System.out.println(c);
        }
    }
}
