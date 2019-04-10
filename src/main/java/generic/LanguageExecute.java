package generic;

import java.util.List;

public class LanguageExecute<T> {

    private TestInterface executor;

    public LanguageExecute(TestInterface<T> executor){
        this.executor = executor;
    }

    public BaseBean<T> list(T t) {
        return executor.list(t);
    }

    public Integer update(T t) {
        return executor.update(t);
    }

    public Integer insert(T t) {
        return null;
    }

    public Integer delete(List<Integer> ids) {
        return executor.delete(ids);
    }
}
