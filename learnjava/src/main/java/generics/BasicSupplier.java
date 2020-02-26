package generics;

import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * @author: xiangming
 * @date: 2020/02/26 03:19
 * @describetion:
 */
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> t){
        type = t;
    }

    @Override
    @SneakyThrows
    public T get() {
        return type.newInstance();
    }

    public static <T> Supplier<T> createObject(Class<T> t){
        return new BasicSupplier<T>(t);
    }
}
