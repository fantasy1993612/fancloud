package typeinfo;

/**
 * @Auther: xiangming
 * @Date: 2020/2/20 16:46
 * @Description:
 */
// typeinfo/Position.java

import java.util.*;

class EmptyTitleException extends RuntimeException {
}

class Position {
    private String title;
    private Person person;

    Position(String jobTitle, Person employee) {
        setTitle(jobTitle);
        setPerson(employee);
    }

    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return title;
    }

    /**
     *
     *这里使用 Optional 的方式不太一样。请注意，
     * title 和 person 都是普通字段，不受 Optional 的保护。
     * 但是，修改这些字段的唯一途径是调用 setTitle() 和 setPerson() 方法，
     * 这两个都借助 Optional 对字段进行了严格的限制。
     * 同时，我们想保证 title 字段永远不会变成 null 值。为此，
     * 我们可以自己在 setTitle() 方法里边检查参数 newTitle 的值。
     */
    public void setTitle(String newTitle) {
        // Throws EmptyTitleException if newTitle is null:
        title = Optional.ofNullable(newTitle)
                .orElseThrow(EmptyTitleException::new);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        // Uses empty Person if newPerson is null:
        person = Optional.ofNullable(newPerson)
                .orElse(new Person());
    }

    @Override
    public String toString() {
        return "Position: " + title +
                ", Employee: " + person;
    }

    public static void main(String[] args) {
        System.out.println(new Position("CEO"));
        System.out.println(new Position("Programmer",
                new Person("Arthur", "Fonzarelli")));
        try {
            new Position(null);
        } catch (Exception e) {
            System.out.println("caught " + e);
        }
     }
}

