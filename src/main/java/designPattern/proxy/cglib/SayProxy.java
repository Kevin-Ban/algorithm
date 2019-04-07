package designPattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/**
 * jdk实现动态代理，每一个动态代理类相当于一个aop
 */
public class SayProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理之前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("代理完成");
        return result;
    }
}
