package reflect;

import designPattern.singleton.Singleton;
import designPattern.singleton.SingletonEnum;
import designPattern.singleton.SingletonEnumTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class clazz = TestClass.class;
//        // region 属性
//        Field[] fields = clazz.getFields();
//        System.out.println("========================属性===============================");
//        for (Field field : fields) {
//            //获取访问权限并输出
//            int modifiers = field.getModifiers();
//            System.out.print(Modifier.toString(modifiers) + " ");
//            //输出变量的类型及变量名
//            System.out.println(field.getType().getName() + " " + field.getName());
//        }
//        System.out.println("========================属性===============================");
//        // endregion
//
//        // region 方法
//        Method[] methods = clazz.getMethods();
//        System.out.println("========================方法===============================");
//        for(Method method : methods){
//            System.out.println(Modifier.toString(method.getModifiers()) + '\t' + method.getReturnType().toString() + '\t' + method.getName());
//        }
//        System.out.println("==================");
//        Constructor[] constructor = clazz.getConstructors();
//        for(Constructor method : constructor){
//            System.out.println(Modifier.toString(method.getModifiers()) + '\t' + method.getName() + '\t' + method.getParameterTypes());
//        }
//        System.out.println("========================方法===============================");
//        // endregion
//
//        // region test
//        Method method = clazz.getDeclaredMethod("testPrivate");
//        method.setAccessible(true);
//        try {
//            Object instance = clazz.newInstance();
//            method.invoke(instance);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        // endregion

        // region 单例

        Class singleClass = Singleton.class;
        Constructor constructor = singleClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance1 = (Singleton) constructor.newInstance();
        Singleton instance2 = (Singleton) constructor.newInstance();
        System.out.println(instance1 == instance2);

//        Class singleEnum = SingletonEnum.class;
//        Constructor constructor1 = singleEnum.getDeclaredConstructor();
//        constructor1.setAccessible(true);
//        SingletomEnumTest singletonEnumTest = (SingletomEnumTest) constructor1.newInstance();
//        SingletomEnumTest singletonEnumTest1 = (SingletomEnumTest) constructor1.newInstance();
//        System.out.println(singletonEnumTest == singletonEnumTest1);

        SingletonEnumTest singletonEnumTest = SingletonEnum.INSTANCE.getInstance();
        SingletonEnumTest singletonEnumTest1 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(singletonEnumTest == singletonEnumTest1);

        //endregion
    }
}
