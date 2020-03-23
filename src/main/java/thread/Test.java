package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            System.out.println((new Random()).nextInt(10));
        }
        System.out.println("主线程运行完毕");
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
