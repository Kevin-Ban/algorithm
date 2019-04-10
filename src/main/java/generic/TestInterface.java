package generic;

import java.util.List;

public interface TestInterface<T extends Object> {

    List<T> list(T t);

    Integer update(T t);

    Integer insert(T t);

    Integer delete(List<Integer> ids);
}
