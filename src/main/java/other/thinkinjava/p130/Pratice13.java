package other.thinkinjava.p130;

/**
 * 静态代码块只会执行一次
 */
public class Pratice13 {

    public static void main(String[] args) {
        Cups.cup1.f(99);
    }

    static Cups cup1 = new Cups();
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}