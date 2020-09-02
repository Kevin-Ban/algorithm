package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSwitch {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String classPath = "test.TestPerson";
        Class clazz = Class.forName(classPath);
        TestPerson person = (TestPerson) clazz.newInstance();
        Field data = clazz.getField("data");
//        data.setInt(person, 2);
        Method getName = clazz.getMethod("getName");
        person.setName("333");
        System.out.println("通过反射调用方法：" + getName.invoke(person));
        System.out.println(person);
    }
}
