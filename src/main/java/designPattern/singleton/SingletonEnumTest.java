package designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonEnumTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 普通单例无法防止反射
        testSingleton();
    }

    private static void testSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = Singleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton singleton = (Singleton) constructor.newInstance();
        Singleton singleton1 = (Singleton) constructor.newInstance();

        System.out.println(singleton == singleton1);
    }
}
