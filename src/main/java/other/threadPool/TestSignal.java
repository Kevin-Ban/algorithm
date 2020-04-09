package other.threadPool;

import java.util.concurrent.Semaphore;

public class TestSignal {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ThreadTest thread1 = new ThreadTest(semaphore);
        ThreadTest thread2 = new ThreadTest(semaphore);
        ThreadTest1 thread3 = new ThreadTest1(semaphore);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ThreadTest extends Thread {

    private Semaphore semaphore;

    public ThreadTest(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "暂停一下");
            semaphore.acquire();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadTest1 extends Thread {

    private Semaphore semaphore;

    public ThreadTest1(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("主线程开始执行");
        semaphore.release(semaphore.availablePermits());
        System.out.println("主线程执行完毕");
    }
}