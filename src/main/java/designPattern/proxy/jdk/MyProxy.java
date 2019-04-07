package designPattern.proxy.jdk;

import java.lang.reflect.Proxy;

public class MyProxy {
    public static void main(String[] args){
        TestInvocationHandler invocationHandler = new TestInvocationHandler(new SayEnglishImpl());
        // 产生动态代理对象，注意这里的参数，非常重要
        Say say = (Say)Proxy.newProxyInstance(SayEnglishImpl.class.getClassLoader(), SayEnglishImpl.class.getInterfaces(), invocationHandler);
        // 对Say代理之后，调用这个方法时，会在该方法的前面或者后面增加一些自定义的操作，是aop的实现方式
        say.sayHello("Hello");
    }
}
