package typeinfo;

/**
 * @author: xiangming
 * @date: 2020/02/16 21:17
 * @describetion:
 */

class Building {}

class House extends Building {


}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b; // ... 或者这样做.
    }
}
