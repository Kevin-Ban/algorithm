package other.generic.test2;

public class Cat<T, E> implements Animal<T> {

    private T age;

    private E color;

    @Override
    public T getAge() {
        return null;
    }

    @Override
    public void setAge(T age) {

    }

    public E getColor() {
        return color;
    }

    public void setColor(E color) {
        this.color = color;
    }
}
