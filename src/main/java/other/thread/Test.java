package other.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        // lock类里面维护了一个state字段，并且使用cas来确保对这个字段的原子操作
        // 当有多个线程尝试获取锁时，使用cas对这个state字段从0加到1，如果有一个线程成功了，那么该线程就获取到锁
        // 而其他线程看到state字段大于0之后，就进入阻塞状态，只有这个字段重新变成0才能有机会重新申请锁资源
        // 对于可重入锁，多次调用同一个锁的lock方法，会对state字段进行累加，而调用unLock()方法会对state字段进行减1操作
        // 所以为了系统安全，调用了一次lock(), 就必须调用一次unLock(), 否则state永远不为0，这意味着其他线程永远无法获取到这个锁
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        List<Integer> data = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            System.out.println((new Random()).nextInt(10));
        }
        System.out.println("主线程运行完毕");
        lock.unlock();
        lock.unlock();
    }

    public static void threadTest() throws InterruptedException {
        Thread t = new ThreadTest();
        t.start();
        // 主线程sleep 1毫秒，让出资源执行其他线程
        Thread.sleep(1);
    }

    public static void runnableTest() throws InterruptedException {
        Thread t = new Thread(new RunableTest());
        t.start();
        // 主线程sleep 1毫秒，让出资源执行其他线程
        Thread.sleep(1);
    }

    public static void callableTest() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
        Thread t = new Thread(futureTask);
        t.start();
//        Thread.sleep(1);
        // futureTask.get() 可以获取到线程的返回结果
        System.out.println(futureTask.get());
    }
}
