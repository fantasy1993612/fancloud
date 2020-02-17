package typeinfo.pets;

/**
 * @author: xiangming
 * @date: 2020/02/16 22:45
 * @describetion:
 */
// 使用 instanceof

import typeinfo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetCount {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        Counter counter = new Counter();
        for (Pet pet : Pets.array(20)) {
            System.out.print(
                    pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");

            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
        }
        // Show the counts:
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

