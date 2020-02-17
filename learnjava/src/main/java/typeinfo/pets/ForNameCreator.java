package typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/02/16 22:26
 * @describetion:
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();
    // 需要随机生成的类型名:
    private static String[] typeNames = {
            "typeinfo.petsCat",
            "typeinfo.pets.Mouse"
    };

    private static void loader(){
        for(String typeName : typeNames){
            try {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        Class<ForNameCreator> forNameCreator = ForNameCreator.class;
    }
}
