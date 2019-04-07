package designPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class MyProxy {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        // 这里的参数不能是接口的class，必须是子类的class
        enhancer.setSuperclass(SayEnglishImpl.class);
        // 设置代理的实现
        enhancer.setCallback(new SayProxy());

        Say say = (Say) enhancer.create();
        say.sayHello("hello");

    }
}
