package other.threadPool;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args){
        // 这个样子表示只有等待两个目标线程达到时才会执行AfterBarrier这个线程，当达到条件时，该线程会自动启动
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new AfterBarrier("123"));
        System.out.println("当前时间：" + System.currentTimeMillis());
        MyThread2 t1 = new MyThread2(cyclicBarrier);
        MyThread2 t2 = new MyThread2(cyclicBarrier);
        t1.start();
        t2.start();

    }
}

class AfterBarrier implements Runnable{

    private String name;

    public AfterBarrier(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("当前时间" + System.currentTimeMillis());
    }
}
