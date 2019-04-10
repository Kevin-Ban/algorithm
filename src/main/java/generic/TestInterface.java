package generic;

import java.util.List;

public interface TestInterface<T extends Object> {

    BaseBean<T> list(T t);

    Integer update(T t);

    Integer insert(T t);

    Integer delete(List<Integer> ids);
}
