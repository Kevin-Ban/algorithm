package other.thinkinjava.p130;

public class Pratice14 {

    public static void main(String[] args) {
//        B b = new B();
//        B b2 = new B();
        A a = new A("构造函数");
        A a2 = new A();
    }
}

class A {
    {
        System.out.println("非静态代码块");
    }

    public A(String flag) {
        System.out.println(flag);
    }

    public A() {
        System.out.println("空构造函数");
    }
}

class B {

    public static A a = new A("静态变量");

    public B() {
        new A("构造方法");
    }

    public A a1 = new A("非静态变量");
}