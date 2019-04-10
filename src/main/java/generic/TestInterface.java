package generic;

public interface TestInterface<T extends Object> {

    <E> E list(T t);
}
