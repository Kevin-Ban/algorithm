package designPattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk实现动态代理，每一个动态代理类相当于一个aop
 */
public class TestInvocationHandler implements InvocationHandler {

    private Object target;

    public TestInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前");
        Object result = method.invoke(target, args);
        System.out.println("代理完成");
        return result;
    }
}
