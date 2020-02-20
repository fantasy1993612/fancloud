package typeinfo;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 17:06
 * @Description:
 */
import java.util.function.*;

public class Operation {
    public final Supplier<String> description;
    public final Runnable command;

    public Operation(Supplier<String> descr, Runnable cmd) {
        description = descr;
        command = cmd;
    }
}

