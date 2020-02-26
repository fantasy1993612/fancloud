package generics;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:41
 * @describetion:
 */


public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        //Array.stream("The quick brown fox jumped over the lazy brown dog".split(" ")).forEach(rs::add);
        IntStream.range(0, 11).forEach(i ->
                System.out.print(rs.select() + " "));
    }
}

