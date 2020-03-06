package generics;

/**
 * @Auther: xiangming
 * @Date: 2020/2/26 17:18
 * @Description:
 */
// generics/CreatorGeneric.java

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class Y {

}

class XCreator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(
                element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();

        GenericWithCreate<Y> yGenericWithCreate;
    }
}


