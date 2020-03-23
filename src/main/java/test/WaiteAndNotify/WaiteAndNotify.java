package test.WaiteAndNotify;

public class WaiteAndNotify {

    public static void main(String[] args) {
        Thread t1 = new SimpleWN.T1();
        Thread t2 = new SimpleWN.T2();
        t1.start();
        t2.start();
    }
}

